package com.poli.simuladorpaginacion.negocio;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface SimuladorPaginacionServicio {

    void iniciarProceso(int tamano);

    void terminarProceso(String id);

    void definirConsumidorNotificacion(Consumer<String> consumidorNotificacion);

    void definirConsumidorListaEspera(Consumer<List<String>> consumidorListaEspera);

    void definirConsumidorListaFinalizado(Consumer<List<String>> consumidorListaFinalizado);

    void definirConsumidorMarcoPagina(BiConsumer<List<String>, List<String>> consumidorMarcoPagina);

}
