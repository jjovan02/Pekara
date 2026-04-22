
package so.kupac;

import java.util.ArrayList;
import model.Kupac;
import so.OpstaSO;


public class VratiListuSviKupac extends OpstaSO<ArrayList<Kupac>> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Kupac))
            throw new Exception("Parametri nisu validni!");

    }


    @Override
    protected ArrayList<Kupac> executeOperation(Object param) throws Exception {

        return (ArrayList<Kupac>) dbr.vratiListuSlozenihSlogova((Kupac) param);
    }
}