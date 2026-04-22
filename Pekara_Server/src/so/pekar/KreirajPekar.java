

package so.pekar;

import model.Pekar;
import so.OpstaSO;

public class KreirajPekar extends OpstaSO<Void> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Pekar)) throw new Exception("Parametri nisu validni!");
    }


    @Override
    protected Void executeOperation(Object param) throws Exception {
        dbr.pamtiSlog((Pekar) param); return null;
    }
}
