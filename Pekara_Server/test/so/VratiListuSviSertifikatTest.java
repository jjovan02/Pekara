package so;

import base.TestBase;
import java.util.ArrayList;
import model.Sertifikat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import so.sertifikat.VratiListuSviSertifikat;

public class VratiListuSviSertifikatTest extends TestBase {

    private VratiListuSviSertifikat soVrati;

    @Before
    public void setUp() {
        soVrati = new VratiListuSviSertifikat();
    }

    @After
    public void tearDown() {
        soVrati = null;
    }

    @Test
    public void testPreconditionIspravan() {
        Sertifikat s = new Sertifikat();
        try {
            soVrati.precondition(s);
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
            soVrati.precondition("nije sertifikat");
            fail("Trebalo je da baci izuzetak za pogresan tip!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testVratiListuUspesno() {
        Sertifikat s = new Sertifikat();
        try {
            ArrayList<Sertifikat> lista =
                    (ArrayList<Sertifikat>) soVrati.execute(s);
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