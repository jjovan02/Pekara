

package so.sertifikat;


import model.Sertifikat;
import so.OpstaSO;


public class PromeniSertifikat extends OpstaSO<Void> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Sertifikat)) throw new Exception("Parametri nisu validni!");
    }


    @Override
    protected Void executeOperation(Object param) throws Exception {
        dbr.promeniSlog((Sertifikat) param); return null;
    }
}
