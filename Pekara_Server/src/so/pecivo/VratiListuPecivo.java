
package so.pecivo;


import java.util.ArrayList;
import model.Pecivo;
import so.OpstaSO;


public class VratiListuPecivo extends OpstaSO<ArrayList<Pecivo>> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Pecivo)) throw new Exception("Parametri nisu validni!");
    }


    @Override
    protected ArrayList<Pecivo> executeOperation(Object param) throws Exception {
        return (ArrayList<Pecivo>) dbr.vratiListuSlogovaKriterijum((Pecivo) param);
    }
}
