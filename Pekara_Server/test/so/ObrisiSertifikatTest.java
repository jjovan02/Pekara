package so;

import base.TestBase;
import model.Sertifikat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import so.sertifikat.ObrisiSertifikat;

public class ObrisiSertifikatTest extends TestBase {

    private ObrisiSertifikat soObrisi;

    @Before
    public void setUp() {
        soObrisi = new ObrisiSertifikat();
    }

    @After
    public void tearDown() {
        soObrisi = null;
    }

    @Test
    public void testPreconditionIspravan() {
        Sertifikat s = new Sertifikat();
        s.setIdSertifikat(2);
        try {
            soObrisi.precondition(s);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak! " + ex.getMessage());
        }
    }

    @Test
    public void testPreconditionNull() {
        try {
            soObrisi.precondition(null);
            fail("Trebalo je da baci izuzetak za null!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testPreconditionPogresanTip() {
        try {
            soObrisi.precondition("nije sertifikat");
            fail("Trebalo je da baci izuzetak za pogresan tip!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testObrisiUspesno() {
        // Brisemo sertifikat ID=2 ali prvo moramo obrisati PS vezu
        // PS (1,2) postoji - zato brisemo PS vezu pa onda sertifikat
        // Alternativno - brisemo sertifikat koji nema PS vezu
        // U bazi PS postoji samo za pekara ID=1 sa sertifikatima 1 i 2
        // Zato kreiramo novi sertifikat pa njega brisemo
        Sertifikat novi = new Sertifikat();
        novi.setNaziv("Sertifikat za brisanje");
        novi.setInstitucija("Test institucija");
        try {
            // Kreiramo pa brisemo - ID ce biti dodeljen
            so.sertifikat.UbaciSertifikat soUbaci = new so.sertifikat.UbaciSertifikat();
            soUbaci.execute(novi);
            novi.setIdSertifikat(novi.getIdSertifikat());
            soObrisi.execute(novi);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak! " + ex.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testObrisiNullBacaIzuzetak() throws Exception {
        soObrisi.execute(null);
    }
}