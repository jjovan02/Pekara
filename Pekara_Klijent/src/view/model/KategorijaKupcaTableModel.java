package view.model;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.KategorijaKupca;


public class KategorijaKupcaTableModel extends AbstractTableModel {
    private ArrayList<KategorijaKupca> lista;
    private String[] kolone = {"ID", "Naziv", "Popust (%)"};

    public KategorijaKupcaTableModel(ArrayList<KategorijaKupca> lista) { 
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
        KategorijaKupca kk = lista.get(row);
        switch (col) {
            case 0: return kk.getIdKategorijaKupca();
            case 1: return kk.getNaziv();
            case 2: return kk.getPopust();
            default: return null;
        }
    }
    public KategorijaKupca getKategorijaKupca(int row) {
        return lista.get(row); 
    }
    
    @Override 
    public String getColumnName(int col) {
        return kolone[col]; 
    }
    
}
