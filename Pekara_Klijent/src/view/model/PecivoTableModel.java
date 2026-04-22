package view.model;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Pecivo;

public class PecivoTableModel extends AbstractTableModel {
    private ArrayList<Pecivo> lista;
    private String[] kolone = {"ID", "Naziv", "Opis", "Rok trajanja", "Cena"};

    public PecivoTableModel(ArrayList<Pecivo> lista) { 
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
        Pecivo p = lista.get(row);
        switch (col) {
            case 0: return p.getIdPecivo();
            case 1: return p.getNaziv();
            case 2: return p.getOpis();
            case 3: return p.getRokTrajanja();
            case 4: return p.getCena();
            default: return null;
        }
    }
    public Pecivo getPecivo(int row) {
        return lista.get(row); 
    }
    
    @Override public String getColumnName(int col) { 
        return kolone[col];
    }
    
}
