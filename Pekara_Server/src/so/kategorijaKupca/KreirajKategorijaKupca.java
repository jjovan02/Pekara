package so.kategorijaKupca;

import java.util.ArrayList;
import model.KategorijaKupca;
import so.OpstaSO;

public class KreirajKategorijaKupca extends OpstaSO<Void> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof KategorijaKupca)) {
            throw new Exception("Parametri nisu validni!");
        }

        KategorijaKupca novaKategorija = (KategorijaKupca) param;

        if (novaKategorija.getNaziv() == null || novaKategorija.getNaziv().trim().isEmpty()) {
            throw new Exception("Naziv kategorije kupca ne sme biti prazan!");
        }

        ArrayList<KategorijaKupca> sveKategorije = dbr.vratiListuSvihSlogova(new KategorijaKupca());

        for (Object obj : sveKategorije) {
            KategorijaKupca kk = (KategorijaKupca) obj;

            if (kk.getNaziv().equalsIgnoreCase(novaKategorija.getNaziv())) {
                throw new Exception("Kategorija kupca sa nazivom \"" + novaKategorija.getNaziv() + "\" već postoji u sistemu!");
            }
        }
    }

    @Override
    protected Void executeOperation(Object param) throws Exception {
        KategorijaKupca kk = (KategorijaKupca) param;
        dbr.pamtiSlog(kk);
        return null;
    }
}