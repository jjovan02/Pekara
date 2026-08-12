package so.pekar;

import java.util.ArrayList;
import model.Pekar;
import so.OpstaSO;

public class PromeniPekar extends OpstaSO<Void> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Pekar)) {
            throw new Exception("Parametri nisu validni!");
        }

        Pekar pekarZaIzmenu = (Pekar) param;

        if (pekarZaIzmenu.getKorisnickoIme() == null || pekarZaIzmenu.getKorisnickoIme().trim().isEmpty()) {
            throw new Exception("Korisničko ime ne sme biti prazno!");
        }

        ArrayList<Pekar> sviPekari = dbr.vratiListuSvihSlogova(new Pekar());

        for (Object obj : sviPekari) {
            Pekar p = (Pekar) obj;

            if (p.getKorisnickoIme().equalsIgnoreCase(pekarZaIzmenu.getKorisnickoIme()) && p.getIdPekar() != pekarZaIzmenu.getIdPekar()) {
                throw new Exception("Korisničko ime \"" + pekarZaIzmenu.getKorisnickoIme() + "\" je već zauzeto!");
            }
        }
    }

    @Override
    protected Void executeOperation(Object param) throws Exception {
        Pekar p = (Pekar) param;
        dbr.promeniSlog(p);
        return null;
    }
}
