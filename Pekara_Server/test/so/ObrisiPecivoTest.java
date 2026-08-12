package so;

import base.TestBase;
import model.Pecivo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import so.pecivo.ObrisiPecivo;

public class ObrisiPecivoTest extends TestBase {

    private ObrisiPecivo soObrisi;

    @Before
    public void setUp() {
        soObrisi = new ObrisiPecivo();
    }

    @After
    public void tearDown() {
        soObrisi = null;
    }

    @Test
    public void testPreconditionIspravan() {
        Pecivo p = new Pecivo();
        p.setIdPecivo(3);
        try {
            soObrisi.precondition(p);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak za ispravan parametar! "
                    + ex.getMessage());
        }
    }

    @Test
    public void testPreconditionNull() {
        try {
            soObrisi.precondition(null);
            fail("Trebalo je da baci izuzetak za null parametar!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testPreconditionPogresanTip() {
        try {
            soObrisi.precondition("nije pecivo");
            fail("Trebalo je da baci izuzetak za pogresan tip!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testObrisiUspesno() {
        // Brisemo Zemicku (ID=3) - postoji u bazi, nema FK zavisnosti
        Pecivo p = new Pecivo();
        p.setIdPecivo(3);
        try {
            soObrisi.execute(p);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak pri brisanju! "
                    + ex.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testObrisiNullBacaIzuzetak() throws Exception {
        soObrisi.execute(null);
    }
}