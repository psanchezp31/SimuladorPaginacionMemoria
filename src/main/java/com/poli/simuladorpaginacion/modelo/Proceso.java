package com.poli.simuladorpaginacion.modelo;

public class Proceso {

    private final String id;
    private final int tamanoPagina;

    public Proceso(String id, int tamanoPagina) {
        this.id = id;
        this.tamanoPagina = tamanoPagina;
    }    
    
    public String getId() {
        return id;
    }

    public int getTamanoPagina() {
        return tamanoPagina;
    }

    @Override
    public String toString() {
        return "{" + "ID:" + id + ", Tamaño:" + tamanoPagina + "}";
    }
    
}

