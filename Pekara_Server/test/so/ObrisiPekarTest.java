package so;

import base.TestBase;
import model.Pekar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import so.pekar.ObrisiPekar;

public class ObrisiPekarTest extends TestBase {

    private ObrisiPekar soObrisi;

    @Before
    public void setUp() {
        soObrisi = new ObrisiPekar();
    }

    @After
    public void tearDown() {
        soObrisi = null;
    }

    @Test
    public void testPreconditionIspravan() {
        Pekar p = new Pekar();
        p.setIdPekar(2);
        try {
            soObrisi.precondition(p);
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
            soObrisi.precondition("nije pekar");
            fail("Trebalo je da baci izuzetak za pogresan tip!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testObrisiUspesno() {
        // Brisemo Marka (ID=2) - postoji u bazi, nema racuna vezanih za njega
        Pekar p = new Pekar();
        p.setIdPekar(2);
        try {
            soObrisi.execute(p);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak! " + ex.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testObrisiNullBacaIzuzetak() throws Exception {
        soObrisi.execute(null);
    }
}
