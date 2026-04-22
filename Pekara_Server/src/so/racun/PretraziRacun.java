package so.racun;

import model.Racun;
import so.OpstaSO;

public class PretraziRacun extends OpstaSO<Racun> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Racun)) {
            throw new Exception("Parametri nisu validni!");
        }
    }

    @Override
    protected Racun executeOperation(Object param) throws Exception {
        return (Racun) dbr.vratiSlog((Racun) param);
    }
}