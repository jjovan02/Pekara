package so.sertifikat;


import java.util.ArrayList;
import model.Sertifikat;
import so.OpstaSO;


public class VratiListuSviSertifikat extends OpstaSO<ArrayList<Sertifikat>> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Sertifikat)) throw new Exception("Parametri nisu validni!");
    }

    @Override
    protected ArrayList<Sertifikat> executeOperation(Object param) throws Exception {
        return (ArrayList<Sertifikat>) dbr.vratiListuSvihSlogova((Sertifikat) param);
    }
}
