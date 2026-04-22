

package so.pecivo;


import model.Pecivo;
import so.OpstaSO;


public class PromeniPecivo extends OpstaSO<Void> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Pecivo)) throw new Exception("Parametri nisu validni!");
    }


    @Override
    protected Void executeOperation(Object param) throws Exception {
        dbr.promeniSlog((Pecivo) param); return null;
    }
}
