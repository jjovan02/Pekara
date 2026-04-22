package so.racun;

import model.Racun;
import model.StavkaRacuna;
import so.OpstaSO;

public class KreirajRacun extends OpstaSO<Void> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Racun))
            throw new Exception("Parametri nisu validni!");

        Racun r = (Racun) param;

        // Kupac i Pekar moraju postojati
        if (r.getKupac() == null) throw new Exception("Račun mora imati kupca!");
        if (r.getPekar() == null) throw new Exception("Račun mora imati pekara!");

        // datumIzdavanja - not null
        if (r.getDatumIzdavanja() == null) throw new Exception("Datum izdavanja ne sme biti prazan!");

        // tipPlacanja - not null i mora biti jedan od tri
        if (r.getTipPlacanja() == null || r.getTipPlacanja().isEmpty()) throw new Exception("Tip plaćanja ne sme biti prazan!");
        if (!r.getTipPlacanja().equals("Gotovina") && !r.getTipPlacanja().equals("Kartica") && !r.getTipPlacanja().equals("Čekovi"))
            throw new Exception("Tip plaćanja mora biti: Gotovina, Kartica ili Čekovi!");

        // popust - not null, >=0 i <=100
        if (r.getPopust() < 0 || r.getPopust() > 100) throw new Exception("Popust mora biti između 0 i 100!");

        // Racun.popust mora biti jednak KategorijaKupca.popust
        if (r.getKupac().getKategorijaKupca() != null && r.getPopust() != r.getKupac().getKategorijaKupca().getPopust())
            throw new Exception("Popust ne odgovara kategoriji kupca!");

        // brojStavki mora biti jednak broju stavki u listi
        if (r.getBrojStavki() != r.getStavke().size()) throw new Exception("Broj stavki nije ispravan!");

        // ukupanIznos mora biti jednak sumi iznosa stavki
        double sumaIznosa = 0;
        for (StavkaRacuna s : r.getStavke()) {
            sumaIznosa += s.getIznos();
        }
        if (Math.abs(r.getUkupanIznos() - sumaIznosa) > 0.001)
            throw new Exception("Ukupan iznos nije ispravan!");

        // iznosSaPopustom = ukupanIznos - ukupanIznos * popust / 100 i mora biti >0
        double ocekivaniIznos = r.getUkupanIznos() - r.getUkupanIznos() * r.getPopust() / 100.0;
        if (Math.abs(r.getIznosSaPopustom() - ocekivaniIznos) > 0.001)
            throw new Exception("Iznos sa popustom nije ispravan!");
        if (r.getIznosSaPopustom() <= 0)
            throw new Exception("Iznos sa popustom mora biti veći od 0!");
    }

    @Override
    protected Void executeOperation(Object param) throws Exception {
        Racun r = (Racun) param;
        dbr.pamtiSlog(r);
        for (StavkaRacuna s : r.getStavke()) {
            s.setRacun(r);
            dbr.pamtiSlog(s);
        }
        return null;
    }
}
