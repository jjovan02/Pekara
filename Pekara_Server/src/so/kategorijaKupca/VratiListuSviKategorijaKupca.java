package so.kategorijaKupca;

import java.util.ArrayList;
import model.KategorijaKupca;
import so.OpstaSO;


public class VratiListuSviKategorijaKupca extends OpstaSO<ArrayList<KategorijaKupca>> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof KategorijaKupca)) throw new Exception("Parametri nisu validni!");
    }

    @Override
    protected ArrayList<KategorijaKupca> executeOperation(Object param) throws Exception {
        return (ArrayList<KategorijaKupca>) dbr.vratiListuSvihSlogova((KategorijaKupca) param);
    }
}
