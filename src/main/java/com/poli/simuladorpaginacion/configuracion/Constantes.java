package com.poli.simuladorpaginacion.configuracion;

public interface Constantes {

    int CAPACIDAD_MARCO_PAGINA = 15;
    String MENSAJE_PROCESO_AGREGADO = "Se ha agregado el proceso %s";
    String MENSAJE_PROCESO_TERMINADO = "Se ha terminado el proceso %s";
    String MENSAJE_PROCESO_INEXISTENTE = "El proceso con id %s no existe";
    String MENSAJE_PROCESO_AGREGADO_DESDE_ESPERA = "El proceso %s ha pasado de espera a ejecución";
    String INSTRUCCIONES = "*** Paginación de memoria ***\n"
            + "\n"
            + "Los sistemas de paginación"
            + " de memoria dividen los programas en pequeñas partes o páginas."
            + " Del mismo modo, la memoria es dividida en trozos del mismo tamaño"
            + " que las páginas llamados marcos de página."
          
            + "En un momento cualquiera, la memoria se encuentra ocupada con"
            + " páginas de diferentes procesos, mientras que algunos marcos están "
            + "disponibles para su uso. El sistema operativo mantiene una lista de "
            + "estos últimos marcos, y una tabla por cada proceso, donde consta en "
            + "qué marco se encuentra cada página del proceso. \n "
            + "Fuente: Wikipedia (2021)\n"
            + "\n"
            + "*** Parametros generales ***\n"
            + "\n"
            + "Capacidad del marco de página: " + CAPACIDAD_MARCO_PAGINA + "\n"
            + "Tamaño máximo de cada proceso: " + CAPACIDAD_MARCO_PAGINA + "\n"
            + "\n"
            + "*** Para iniciar un nuevo proceso ***\n"
            + "\n"
            + "Por favor ingrese el tamaño de página para el nuevo proceso "
            + "y oprima el botón \"Iniciar Proceso\". Posteriormente la "
            + "información relacionada al nuevo proceso aparecerá en la lista "
            + "correspondiente, de acuerdo a la disponibilidad del marco "
            + "de Página.\n"
            + "\n"
            + "*** Para terminar un proceso ***\n"
            + "\n"
            + "Por favor ingrese el ID del proceso a terminar (e.g. P1) y oprima "
            + "el botón \"Terminar Proceso\"."
            + "Si existe un proceso en ejecución asociado al ID ingresado, "
            + "este será actualizado en las listas correspondientes.";

}
