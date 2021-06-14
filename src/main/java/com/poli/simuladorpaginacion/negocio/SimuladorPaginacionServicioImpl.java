/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poli.simuladorpaginacion.negocio;

import com.poli.simuladorpaginacion.configuracion.Constantes;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import com.poli.simuladorpaginacion.modelo.MarcoPagina;
import com.poli.simuladorpaginacion.modelo.Proceso;
import com.poli.simuladorpaginacion.util.MapaProcesosUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class SimuladorPaginacionServicioImpl implements SimuladorPaginacionServicio {

    private MarcoPagina marcoPagina;
    private Map<String, Proceso> mapaEspera;
    private Map<String, Proceso> mapaFinalizado;
    private Consumer<String> consumidorNotificacion;
    private Consumer<List<String>> consumidorListaEspera;
    private Consumer<List<String>> consumidorListaFinalizado;
    private BiConsumer<List<String>, List<String>> consumidorMarcoPagina;
    private int consecutivoId;

    public SimuladorPaginacionServicioImpl() {

        this.marcoPagina = new MarcoPagina(Constantes.CAPACIDAD_MARCO_PAGINA);
        this.mapaEspera = new LinkedHashMap<>();
        this.mapaFinalizado = new LinkedHashMap<>();
        this.consumidorNotificacion = texto
                -> System.out.println("Nueva notificación: " + texto);
        this.consumidorListaEspera = listado
                -> System.out.println("En Espera: " + listado);
        this.consumidorListaFinalizado = listado
                -> System.out.println("Finalizado : " + listado);
        this.consumidorMarcoPagina = (listado, listadoExpandido) -> {
            System.out.println("En Ejecución: " + listado);
            System.out.println("Marco de Página: " + listadoExpandido);
        };

    }

    @Override
    public void iniciarProceso(int tamano) {

        final String id = "P" + this.consecutivoId++;
        Proceso nuevoProceso = new Proceso(id, tamano);

        if (this.marcoPagina.agregarProceso(nuevoProceso)) {
            this.consumidorNotificacion.accept(String.format(
                    Constantes.MENSAJE_PROCESO_AGREGADO,
                    nuevoProceso.toString()));
            actualizarConsumidorMarcoPagina();
        } else {
            this.mapaEspera.put(id, nuevoProceso);
            actualizarConsumidorMapa(mapaEspera, consumidorListaEspera);
        }

    }

    @Override
    public void terminarProceso(String id) {

        var procesoTerminado = this.marcoPagina.terminarProceso(id);
        if (procesoTerminado == null) {
            this.consumidorNotificacion.accept(
                    String.format(Constantes.MENSAJE_PROCESO_INEXISTENTE, id));
        } else {
            this.consumidorNotificacion.accept(String.format(
                    Constantes.MENSAJE_PROCESO_TERMINADO,
                    procesoTerminado.toString()));
            this.mapaFinalizado.put(id, procesoTerminado);
            actualizarConsumidorMapa(mapaFinalizado, consumidorListaFinalizado);

            List<String> idsPorEliminar = new ArrayList<>();
            
            for (Proceso procesoEspera : mapaEspera.values()) {
                if (this.marcoPagina.agregarProceso(procesoEspera)) {
                    this.consumidorNotificacion.accept(String.format(
                            Constantes.MENSAJE_PROCESO_AGREGADO_DESDE_ESPERA,
                            procesoEspera.toString()));
                    idsPorEliminar.add(procesoEspera.getId());                
                }
            }
            
            for (String idPorEliminar : idsPorEliminar) {
                mapaEspera.remove(idPorEliminar);
            }
           
            actualizarConsumidorMapa(mapaEspera, consumidorListaEspera);
            actualizarConsumidorMarcoPagina();
        }

    }

    private void actualizarConsumidorMapa(
            Map<String, Proceso> mapa,
            Consumer<List<String>> consumidor) {
        var procesosTerminados = MapaProcesosUtil.formatearProcesos(mapa);
        consumidor.accept(procesosTerminados);
    }

    private void actualizarConsumidorMarcoPagina() {
        this.consumidorMarcoPagina.accept(
                this.marcoPagina.obtenerProcesos(),
                this.marcoPagina.obtenerProcesosExpandidos());
    }

    @Override
    public void definirConsumidorNotificacion(
            Consumer<String> consumidorNotificacion) {
        this.consumidorNotificacion = consumidorNotificacion;
    }

    @Override
    public void definirConsumidorListaEspera(
            Consumer<List<String>> consumidorListaEspera) {
        this.consumidorListaEspera = consumidorListaEspera;
    }

    @Override
    public void definirConsumidorListaFinalizado(
            Consumer<List<String>> consumidorListaFinalizado) {
        this.consumidorListaFinalizado = consumidorListaFinalizado;
    }

    @Override
    public void definirConsumidorMarcoPagina(
            BiConsumer<List<String>, List<String>> consumidorMarcoPagina) {
        this.consumidorMarcoPagina = consumidorMarcoPagina;
    }

}
