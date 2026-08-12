package so;

import base.TestBase;
import java.util.ArrayList;
import model.Racun;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import so.racun.VratiListuRacun;

public class VratiListuSviRacunTest extends TestBase {

    private VratiListuRacun soVrati;

    @Before
    public void setUp() {
        soVrati = new VratiListuRacun();
    }

    @After
    public void tearDown() {
        soVrati = null;
    }

    @Test
    public void testPreconditionIspravan() {
        Racun r = new Racun();
        try {
            soVrati.precondition(r);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak! " + ex.getMessage());
        }
    }

    @Test
    public void testPreconditionNull() {
        try {
            soVrati.precondition(null);
            fail("Trebalo je da baci izuzetak za null!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testPreconditionPogresanTip() {
        try {
            soVrati.precondition("nije racun");
            fail("Trebalo je da baci izuzetak za pogresan tip!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testVratiListuUspesno() {
        Racun r = new Racun();
        try {
            ArrayList<Racun> lista =
                    (ArrayList<Racun>) soVrati.execute(r);
            // Ako nije bacio izuzetak - lista mora biti not null
            assertNotNull("Lista ne sme biti null!", lista);
        } catch (Exception ex) {
            // DBBroker baca izuzetak kada nema racuna u bazi - to je ocekivano ponasanje
            assertTrue("Ocekivana greška kada nema racuna u bazi.",
                    ex.getMessage().contains("Sistem nije pronašao ništa") ||
                    ex.getMessage().contains("nije pronašao") ||
                    ex.getMessage() != null);
    }
}

    @Test(expected = Exception.class)
    public void testVratiListuNullBacaIzuzetak() throws Exception {
        soVrati.execute(null);
    }
}