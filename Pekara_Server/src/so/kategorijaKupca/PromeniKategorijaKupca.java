package so.kategorijaKupca;

import java.util.ArrayList;
import model.KategorijaKupca;
import so.OpstaSO;

public class PromeniKategorijaKupca extends OpstaSO<Void> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof KategorijaKupca)) {
            throw new Exception("Parametri nisu validni!");
        }

        KategorijaKupca kategorijaZaIzmenu = (KategorijaKupca) param;

        if (kategorijaZaIzmenu.getNaziv() == null || kategorijaZaIzmenu.getNaziv().trim().isEmpty()) {
            throw new Exception("Naziv kategorije kupca ne sme biti prazan!");
        }

        ArrayList<KategorijaKupca> sveKategorije = dbr.vratiListuSvihSlogova(new KategorijaKupca());

        for (Object obj : sveKategorije) {
            KategorijaKupca kk = (KategorijaKupca) obj;

            if (kk.getNaziv().equalsIgnoreCase(kategorijaZaIzmenu.getNaziv()) 
                    && kk.getIdKategorijaKupca() != kategorijaZaIzmenu.getIdKategorijaKupca()) {
                throw new Exception("Kategorija kupca sa nazivom \"" + kategorijaZaIzmenu.getNaziv() + "\" već postoji u sistemu!");
            }
        }
    }

    @Override
    protected Void executeOperation(Object param) throws Exception {
        KategorijaKupca kk = (KategorijaKupca) param;
        dbr.promeniSlog(kk);
        return null;
    }
}