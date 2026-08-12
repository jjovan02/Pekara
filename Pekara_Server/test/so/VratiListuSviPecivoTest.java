package so;

import base.TestBase;
import java.util.ArrayList;
import model.Pecivo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import so.pecivo.VratiListuSviPecivo;

public class VratiListuSviPecivoTest extends TestBase {

    private VratiListuSviPecivo soVrati;

    @Before
    public void setUp() {
        soVrati = new VratiListuSviPecivo();
    }

    @After
    public void tearDown() {
        soVrati = null;
    }

    @Test
    public void testPreconditionIspravan() {
        Pecivo p = new Pecivo();
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
            soVrati.precondition("nije pecivo");
            fail("Trebalo je da baci izuzetak za pogresan tip!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testVratiListuUspesno() {
        Pecivo p = new Pecivo();
        try {
            ArrayList<Pecivo> lista =
                    (ArrayList<Pecivo>) soVrati.execute(p);
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