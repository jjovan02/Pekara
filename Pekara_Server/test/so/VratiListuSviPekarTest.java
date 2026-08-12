package so;

import base.TestBase;
import java.util.ArrayList;
import model.Pekar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import so.pekar.VratiListuSviPekar;

public class VratiListuSviPekarTest extends TestBase {

    private VratiListuSviPekar soVrati;

    @Before
    public void setUp() {
        soVrati = new VratiListuSviPekar();
    }

    @After
    public void tearDown() {
        soVrati = null;
    }

    @Test
    public void testPreconditionIspravan() {
        Pekar p = new Pekar();
        try {
            soVrati.precondition(p);
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
            soVrati.precondition("nije pekar");
            fail("Trebalo je da baci izuzetak za pogresan tip!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testVratiListuUspesno() {
        Pekar p = new Pekar();
        try {
            ArrayList<Pekar> lista =
                    (ArrayList<Pekar>) soVrati.execute(p);
            assertNotNull("Lista ne sme biti null!", lista);
            assertTrue("Lista mora imati bar jedan element!", lista.size() > 0);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak! " + ex.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testVratiListuNullBacaIzuzetak() throws Exception {
        soVrati.execute(null);
    }
}