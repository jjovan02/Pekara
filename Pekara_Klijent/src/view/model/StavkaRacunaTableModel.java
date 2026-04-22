

package view.model;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.StavkaRacuna;

public class StavkaRacunaTableModel extends AbstractTableModel {
    private ArrayList<StavkaRacuna> lista;
    private String[] kolone = {"Rb", "Pecivo", "Cena", "Količina", "Iznos"};

    public StavkaRacunaTableModel(ArrayList<StavkaRacuna> lista) {
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
        StavkaRacuna s = lista.get(row);
        switch (col) {
            case 0: return s.getRb();
            case 1: return s.getPecivo() != null ? s.getPecivo().getNaziv() : "";
            case 2: return s.getCena();
            case 3: return s.getKolicina();
            case 4: return s.getIznos();
            default: return null;
        }
    }
    public StavkaRacuna getStavka(int row) { 
        return lista.get(row); 
    }

    @Override 
    public String getColumnName(int col) { 
        return kolone[col]; 
    }

}
