package so;

import base.TestBase;
import java.util.ArrayList;
import model.KategorijaKupca;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import so.kategorijaKupca.VratiListuSviKategorijaKupca;

public class VratiListuSviKategorijaKupcaTest extends TestBase {

    private VratiListuSviKategorijaKupca soVrati;

    @Before
    public void setUp() {
        soVrati = new VratiListuSviKategorijaKupca();
    }

    @After
    public void tearDown() {
        soVrati = null;
    }

    @Test
    public void testPreconditionIspravan() {
        KategorijaKupca kk = new KategorijaKupca();
        try {
            soVrati.precondition(kk);
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
            soVrati.precondition("nije kategorija");
            fail("Trebalo je da baci izuzetak za pogresan tip!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testVratiListuUspesno() {
        KategorijaKupca kk = new KategorijaKupca();
        try {
            ArrayList<KategorijaKupca> lista =
                    (ArrayList<KategorijaKupca>) soVrati.execute(kk);
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