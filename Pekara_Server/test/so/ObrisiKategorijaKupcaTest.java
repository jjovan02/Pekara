package so;

import base.TestBase;
import model.KategorijaKupca;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import so.kategorijaKupca.ObrisiKategorijaKupca;

public class ObrisiKategorijaKupcaTest extends TestBase {

    private ObrisiKategorijaKupca soObrisi;

    @Before
    public void setUp() {
        soObrisi = new ObrisiKategorijaKupca();
    }

    @After
    public void tearDown() {
        soObrisi = null;
    }

    @Test
    public void testPreconditionIspravan() {
        KategorijaKupca kk = new KategorijaKupca();
        kk.setIdKategorijaKupca(3);
        try {
            soObrisi.precondition(kk);
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
            soObrisi.precondition("nije kategorija");
            fail("Trebalo je da baci izuzetak za pogresan tip!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testObrisiUspesno() {
        // Brisemo kategoriju sa ID=3 (Zlatni) - postoji u bazi
        KategorijaKupca kk = new KategorijaKupca();
        kk.setIdKategorijaKupca(3);
        try {
            soObrisi.execute(kk);
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