package so;

import base.TestBase;
import model.Sertifikat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import so.sertifikat.PromeniSertifikat;

public class PromeniSertifikatTest extends TestBase {

    private PromeniSertifikat soPromeni;

    @Before
    public void setUp() {
        soPromeni = new PromeniSertifikat();
    }

    @After
    public void tearDown() {
        soPromeni = null;
    }

    @Test
    public void testPreconditionIspravan() {
        Sertifikat s = new Sertifikat();
        s.setIdSertifikat(1);
        s.setNaziv("Master pekar napredni");
        s.setInstitucija("Pekarska skola Beograd");
        try {
            soPromeni.precondition(s);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak! " + ex.getMessage());
        }
    }

    @Test
    public void testPreconditionNull() {
        try {
            soPromeni.precondition(null);
            fail("Trebalo je da baci izuzetak za null!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testPreconditionPogresanTip() {
        try {
            soPromeni.precondition("nije sertifikat");
            fail("Trebalo je da baci izuzetak za pogresan tip!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testPromeniUspesno() {
        Sertifikat s = new Sertifikat();
        s.setIdSertifikat(1);
        s.setNaziv("Master pekar izmenjen");
        s.setInstitucija("Pekarska skola Novi Sad");
        try {
            soPromeni.execute(s);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak! " + ex.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testPromeniNullBacaIzuzetak() throws Exception {
        soPromeni.execute(null);
    }
}