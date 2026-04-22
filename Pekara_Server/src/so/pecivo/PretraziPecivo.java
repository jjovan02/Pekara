package so.pecivo;

import model.Pecivo;
import so.OpstaSO;

public class PretraziPecivo extends OpstaSO<Pecivo> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Pecivo)) {
            throw new Exception("Parametri nisu validni!");
        }
    }

    @Override
    protected Pecivo executeOperation(Object param) throws Exception {
        return (Pecivo) dbr.vratiSlog((Pecivo) param);
    }
}