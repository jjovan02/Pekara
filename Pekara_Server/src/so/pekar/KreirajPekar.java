package so.pekar;

import java.util.ArrayList;
import model.Pekar;
import so.OpstaSO;

public class KreirajPekar extends OpstaSO<Void> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Pekar)) {
            throw new Exception("Parametri nisu validni!");
        }

        Pekar noviPekar = (Pekar) param;

        if (noviPekar.getKorisnickoIme() == null || noviPekar.getKorisnickoIme().trim().isEmpty()) {
            throw new Exception("Korisničko ime ne sme biti prazno!");
        }

        ArrayList<Pekar> sviPekari = dbr.vratiListuSvihSlogova(new Pekar());

        for (Object obj : sviPekari) {
            Pekar p = (Pekar) obj;

            if (p.getKorisnickoIme().equalsIgnoreCase(noviPekar.getKorisnickoIme())) {
                throw new Exception("Pekar sa korisničkim imenom \"" + noviPekar.getKorisnickoIme() + "\" već postoji u sistemu!");
            }
        }
    }

    @Override
    protected Void executeOperation(Object param) throws Exception {
        Pekar p = (Pekar) param;
        dbr.pamtiSlog(p);
        return null;
    }
}