

package so.kupac;


import model.Kupac;
import so.OpstaSO;


public class PromeniKupac extends OpstaSO<Void> {
    
    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Kupac)) throw new Exception("Parametri nisu validni!");
    }
    
    
    @Override
    protected Void executeOperation(Object param) throws Exception {
        dbr.promeniSlog((Kupac) param); return null;
    }
}
