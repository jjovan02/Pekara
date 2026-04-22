package so.sertifikat;

import model.Sertifikat;
import so.OpstaSO;

public class PretraziSertifikat extends OpstaSO<Sertifikat> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Sertifikat)) {
            throw new Exception("Parametri nisu validni!");
        }
    }

    @Override
    protected Sertifikat executeOperation(Object param) throws Exception {
        return (Sertifikat) dbr.vratiSlog((Sertifikat) param);
    }
}