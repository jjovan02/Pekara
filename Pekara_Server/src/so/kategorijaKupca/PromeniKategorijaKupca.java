

package so.kategorijaKupca;

import model.KategorijaKupca;
import so.OpstaSO;


public class PromeniKategorijaKupca extends OpstaSO<Void> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof KategorijaKupca)) throw new Exception("Parametri nisu validni!");
    }


    @Override
    protected Void executeOperation(Object param) throws Exception {
        dbr.promeniSlog((KategorijaKupca) param); return null;
    }
}
