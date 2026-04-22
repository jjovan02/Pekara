package view.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Sertifikat;

public class SertifikatTableModel extends AbstractTableModel {
    private ArrayList<Sertifikat> lista;
    private String[] kolone = {"ID", "Naziv", "Institucija"};

    public SertifikatTableModel(ArrayList<Sertifikat> lista) { 
        this.lista = lista;
    }

    @Override
    public int getRowCount() { 
        return lista.size();
    }
    
    @Override 
    public int getColumnCount() {
        return kolone.length; 
    }
    

    @Override
    public Object getValueAt(int row, int col) {
        Sertifikat s = lista.get(row);
        switch (col) {
            case 0: return s.getIdSertifikat();
            case 1: return s.getNaziv();
            case 2: return s.getInstitucija();
            default: return null;
        }
    }
    
    @Override 
    public String getColumnName(int col) {
        return kolone[col];
    }
    
    public Sertifikat getSertifikat(int row) { 
        return lista.get(row); 
    }
    
    
}



