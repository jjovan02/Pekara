package so.sertifikat;

import java.util.ArrayList;
import model.Sertifikat;
import so.OpstaSO;

public class PromeniSertifikat extends OpstaSO<Void> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Sertifikat)) {
            throw new Exception("Parametri nisu validni!");
        }

        Sertifikat sertifikatZaIzmenu = (Sertifikat) param;

        if (sertifikatZaIzmenu.getNaziv() == null || sertifikatZaIzmenu.getNaziv().trim().isEmpty()) {
            throw new Exception("Naziv sertifikata ne sme biti prazan!");
        }
        if (sertifikatZaIzmenu.getInstitucija() == null || sertifikatZaIzmenu.getInstitucija().trim().isEmpty()) {
            throw new Exception("Institucija ne sme biti prazna!");
        }

        ArrayList<Sertifikat> sviSertifikati = dbr.vratiListuSvihSlogova(new Sertifikat());

        for (Object obj : sviSertifikati) {
            Sertifikat s = (Sertifikat) obj;

            if (s.getNaziv().equalsIgnoreCase(sertifikatZaIzmenu.getNaziv()) 
                    && s.getInstitucija().equalsIgnoreCase(sertifikatZaIzmenu.getInstitucija()) 
                    && s.getIdSertifikat() != sertifikatZaIzmenu.getIdSertifikat()) {
                throw new Exception("Sertifikat sa nazivom \"" + sertifikatZaIzmenu.getNaziv() 
                        + "\" i institucijom \"" + sertifikatZaIzmenu.getInstitucija() + "\" je već zauzet kod drugog zapisa!");
            }
        }
    }

    @Override
    protected Void executeOperation(Object param) throws Exception {
        Sertifikat s = (Sertifikat) param;
        dbr.promeniSlog(s);
        return null;
    }
}