
package view.model;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Kupac;

public class KupacTableModel extends AbstractTableModel {
    private ArrayList<Kupac> lista;
    private String[] kolone = {"ID", "Ime", "Prezime", "Email", "Kategorija"};

    public KupacTableModel(ArrayList<Kupac> lista) { 
        this.lista = lista; 
    }

    @Override 
    public int getRowCount() {
        return lista.size();
    }
    
    
    @Override public int getColumnCount() { 
        return kolone.length; 
    }
    
    
    @Override
    public Object getValueAt(int row, int col) {
        Kupac k = lista.get(row);
        switch (col) {
            case 0: return k.getIdKupac();
            case 1: return k.getIme();
            case 2: return k.getPrezime();
            case 3: return k.getEmail();
            case 4: return k.getKategorijaKupca() != null ? k.getKategorijaKupca().getNaziv() : "";
            default: return null;
        }
    }
    
    public Kupac getKupac(int row) { 
        return lista.get(row); 
    }
    
    
     @Override public String getColumnName(int col) { 
        return kolone[col];
    }
    
}
