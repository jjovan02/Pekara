package so.racun;

import java.util.ArrayList;
import model.Racun;
import model.StavkaRacuna;
import so.OpstaSO;

public class VratiListuRacun extends OpstaSO<ArrayList<Racun>> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Racun))
            throw new Exception("Parametri nisu validni!");
    }

    @Override
    protected ArrayList<Racun> executeOperation(Object param) throws Exception {
        ArrayList<Racun> racuni =
            (ArrayList<Racun>) dbr.vratiListuSlozenihSlogova((Racun) param);

        for (Racun r : racuni) {
            StavkaRacuna filter = new StavkaRacuna();
            filter.setIdRacun(r.getIdRacun());
            try {
                ArrayList<StavkaRacuna> stavke = (ArrayList<StavkaRacuna>) dbr.vratiListuSlozenihSlogova(filter);
                r.setStavke(stavke);
            } catch (Exception ex) {
                r.setStavke(new ArrayList<>());
            }
        }

        return racuni;
    }
}
