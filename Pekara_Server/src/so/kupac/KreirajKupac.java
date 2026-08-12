package so.kupac;

import java.util.ArrayList;
import model.Kupac;
import so.OpstaSO;

public class KreirajKupac extends OpstaSO<Void> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Kupac)) {
            throw new Exception("Parametri nisu validni!");
        }

        Kupac noviKupac = (Kupac) param;

        if (noviKupac.getEmail() == null || noviKupac.getEmail().trim().isEmpty()) {
            throw new Exception("Email ne sme biti prazan!");
        }

        ArrayList<Kupac> sviKupci = dbr.vratiListuSvihSlogova(new Kupac());

        for (Object obj : sviKupci) {
            Kupac k = (Kupac) obj;

            if (k.getEmail().equalsIgnoreCase(noviKupac.getEmail())) {
                throw new Exception("Kupac sa email adresom \"" + noviKupac.getEmail() + "\" već postoji u sistemu!");
            }
        }
    }

    @Override
    protected Void executeOperation(Object param) throws Exception {
        Kupac k = (Kupac) param;
        dbr.pamtiSlog(k);
        return null;
    }
}