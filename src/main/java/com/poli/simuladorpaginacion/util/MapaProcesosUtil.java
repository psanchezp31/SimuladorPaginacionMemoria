/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poli.simuladorpaginacion.util;

import com.poli.simuladorpaginacion.modelo.Proceso;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapaProcesosUtil {
    
    private MapaProcesosUtil() {
        
    }
    
    public static List<String> formatearProcesos(Map<String, Proceso> mapa) {
        
         List<String> listaProcesos = new ArrayList<>();
        Set<Map.Entry<String, Proceso>> entries = mapa.entrySet();

        for (Map.Entry<String, Proceso> entry : entries) {
            listaProcesos.add(entry.getValue().toString());
        }

        return listaProcesos;
        
    }
    
}
