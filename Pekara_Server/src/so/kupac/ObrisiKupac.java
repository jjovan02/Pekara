

package so.kupac;

import model.Kupac;
import so.OpstaSO;


public class ObrisiKupac extends OpstaSO<Void> {

    @Override
    public  void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Kupac)) throw new Exception("Parametri nisu validni!");
    }

    @Override
    protected Void executeOperation(Object param) throws Exception {
        dbr.brisiSlog((Kupac) param); return null;

    }
}


