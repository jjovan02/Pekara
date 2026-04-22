package so.pekar;

import model.Pekar;
import so.OpstaSO;

public class PretraziPekar extends OpstaSO<Pekar> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Pekar)) {
            throw new Exception("Parametri nisu validni!");
        }
    }

    @Override
    protected Pekar executeOperation(Object param) throws Exception {
        return (Pekar) dbr.vratiSlog((Pekar) param);
    }
}