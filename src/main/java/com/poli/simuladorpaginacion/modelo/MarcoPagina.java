package com.poli.simuladorpaginacion.modelo;

import com.poli.simuladorpaginacion.util.MapaProcesosUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MarcoPagina {

    private int cantidadOcupada;
    private final int capacidad;
    private final Map<String, Proceso> procesos;

    public MarcoPagina(int capacidad) {
        this.capacidad = capacidad;
        this.procesos = new LinkedHashMap<>();
    }

    public int getCapacidad() {
        return capacidad;
    }

    public List<String> obtenerProcesosExpandidos() {

        List<String> listaProcesos = new ArrayList<>();
        Set<Map.Entry<String, Proceso>> entries = procesos.entrySet();

        for (Map.Entry<String, Proceso> entry : entries) {
            listaProcesos.addAll(this.expandirProceso(entry.getValue()));
        }

        return listaProcesos;

    }

    public List<String> obtenerProcesos() {

        return MapaProcesosUtil.formatearProcesos(procesos);

    }

    public boolean verificarDisponibilidad(int tamano) {
        return (tamano + this.cantidadOcupada) <= this.capacidad;
    }

    /**
     * Agrega un proceso si existe disponibilidad e incrementa la cantidad de
     * memoria ocupada.
     *
     * @param proceso Proceso a agregar
     * @return true si se pudo agregar, false de lo contrario.
     */
    public boolean agregarProceso(Proceso proceso) {

        if (verificarDisponibilidad(proceso.getTamanoPagina())) {
            this.procesos.put(proceso.getId(), proceso);
            this.cantidadOcupada += proceso.getTamanoPagina();
            return true;
        }

        return false;

    }

    public Proceso terminarProceso(String id) {

        if (this.procesos.containsKey(id)) {
            final Proceso procesoEliminado = this.procesos.get(id);
            this.cantidadOcupada -= procesoEliminado.getTamanoPagina();
            this.procesos.remove(id);
            return procesoEliminado;
        }

        return null;

    }

    private List<String> expandirProceso(Proceso proceso) {

        List<String> resultado = new ArrayList<>();

        for (int i = 0; i < proceso.getTamanoPagina(); i++) {
            resultado.add(proceso.getId());
        }

        return resultado;

    }

}
