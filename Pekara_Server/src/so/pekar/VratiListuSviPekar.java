package so.pekar;

import java.util.ArrayList;
import model.Pekar;
import so.OpstaSO;


public class VratiListuSviPekar extends OpstaSO<ArrayList<Pekar>> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Pekar)) throw new Exception("Parametri nisu validni!");
    }

    @Override
    protected ArrayList<Pekar> executeOperation(Object param) throws Exception {
        return (ArrayList<Pekar>) dbr.vratiListuSvihSlogova((Pekar) param);
    }
}
