package so.kupac;

import java.util.ArrayList;
import model.Kupac;
import so.OpstaSO;

public class PromeniKupac extends OpstaSO<Void> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Kupac)) {
            throw new Exception("Parametri nisu validni!");
        }

        Kupac kupacZaIzmenu = (Kupac) param;

        if (kupacZaIzmenu.getEmail() == null || kupacZaIzmenu.getEmail().trim().isEmpty()) {
            throw new Exception("Email ne sme biti prazan!");
        }

        ArrayList<Kupac> sviKupci = dbr.vratiListuSvihSlogova(new Kupac());

        for (Object obj : sviKupci) {
            Kupac k = (Kupac) obj;

            if (k.getEmail().equalsIgnoreCase(kupacZaIzmenu.getEmail()) && k.getIdKupac() != kupacZaIzmenu.getIdKupac()) {
                throw new Exception("Email adresa \"" + kupacZaIzmenu.getEmail() + "\" je već zauzeta!");
            }
        }
    }

    @Override
    protected Void executeOperation(Object param) throws Exception {
        Kupac k = (Kupac) param;
        dbr.promeniSlog(k);
        return null;
    }
}
