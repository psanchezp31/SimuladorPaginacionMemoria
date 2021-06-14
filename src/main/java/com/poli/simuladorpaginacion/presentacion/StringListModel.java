package com.poli.simuladorpaginacion.presentacion;

import java.util.ArrayList;
import java.util.List;

public class StringListModel extends javax.swing.AbstractListModel<String> {

    private List<String> values = new ArrayList<>();

    public StringListModel(List<String> values) {
        this.values = values;
    }

    @Override
    public int getSize() {
        return values.size();
    }

    @Override
    public String getElementAt(int index) {
        return values.get(index);
    }

}
