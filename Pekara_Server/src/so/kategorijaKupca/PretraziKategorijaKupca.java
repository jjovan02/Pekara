package so.kategorijaKupca;

import model.KategorijaKupca;
import so.OpstaSO;

public class PretraziKategorijaKupca extends OpstaSO<KategorijaKupca> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof KategorijaKupca)) {
            throw new Exception("Parametri nisu validni!");
        }
    }

    @Override
    protected KategorijaKupca executeOperation(Object param) throws Exception {
        return (KategorijaKupca) dbr.vratiSlog((KategorijaKupca) param);
    }
}