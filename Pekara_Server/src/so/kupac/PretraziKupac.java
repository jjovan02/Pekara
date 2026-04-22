package so.kupac;

import model.Kupac;
import so.OpstaSO;

public class PretraziKupac extends OpstaSO<Kupac> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Kupac)) {
            throw new Exception("Parametri nisu validni!");
        }
    }

    @Override
    protected Kupac executeOperation(Object param) throws Exception {
        return (Kupac) dbr.vratiSlog((Kupac) param);
    }
}
