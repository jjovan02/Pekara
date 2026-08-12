package so.sertifikat;

import java.util.ArrayList;
import model.Sertifikat;
import so.OpstaSO;

public class UbaciSertifikat extends OpstaSO<Void> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Sertifikat)) {
            throw new Exception("Parametri nisu validni!");
        }

        Sertifikat noviSertifikat = (Sertifikat) param;

        if (noviSertifikat.getNaziv() == null || noviSertifikat.getNaziv().trim().isEmpty()) {
            throw new Exception("Naziv sertifikata ne sme biti prazan!");
        }
        if (noviSertifikat.getInstitucija() == null || noviSertifikat.getInstitucija().trim().isEmpty()) {
            throw new Exception("Institucija ne sme biti prazna!");
        }

        ArrayList<Sertifikat> sviSertifikati = dbr.vratiListuSvihSlogova(new Sertifikat());

        for (Object obj : sviSertifikati) {
            Sertifikat s = (Sertifikat) obj;

            if (s.getNaziv().equalsIgnoreCase(noviSertifikat.getNaziv()) 
                    && s.getInstitucija().equalsIgnoreCase(noviSertifikat.getInstitucija())) {
                throw new Exception("Sertifikat sa nazivom \"" + noviSertifikat.getNaziv() 
                        + "\" i institucijom \"" + noviSertifikat.getInstitucija() + "\" već postoji u sistemu!");
            }
        }
    }

    @Override
    protected Void executeOperation(Object param) throws Exception {
        Sertifikat s = (Sertifikat) param;
        dbr.pamtiSlog(s);
        return null;
    }
}
