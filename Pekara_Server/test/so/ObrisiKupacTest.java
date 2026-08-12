package so;

import base.TestBase;
import model.Kupac;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import so.kupac.ObrisiKupac;

public class ObrisiKupacTest extends TestBase {

    private ObrisiKupac soObrisi;

    @Before
    public void setUp() {
        soObrisi = new ObrisiKupac();
    }

    @After
    public void tearDown() {
        soObrisi = null;
    }

    @Test
    public void testPreconditionIspravan() {
        Kupac k = new Kupac();
        k.setIdKupac(2);
        try {
            soObrisi.precondition(k);
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
            soObrisi.precondition("nije kupac");
            fail("Trebalo je da baci izuzetak za pogresan tip!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testObrisiUspesno() {
        // Brisemo Anu (ID=2) - postoji u bazi, nema racuna vezanih za nju
        Kupac k = new Kupac();
        k.setIdKupac(2);
        try {
            soObrisi.execute(k);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak! " + ex.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testObrisiNullBacaIzuzetak() throws Exception {
        soObrisi.execute(null);
    }
}