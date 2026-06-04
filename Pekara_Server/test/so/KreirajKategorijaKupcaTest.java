package so;

import base.TestBase;
import model.KategorijaKupca;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import so.kategorijaKupca.KreirajKategorijaKupca;


public class KreirajKategorijaKupcaTest extends TestBase {

    private KreirajKategorijaKupca soKreiraj;
    private KategorijaKupca kategorijaKupca;

    @Before
    public void setUp() {
        soKreiraj = new KreirajKategorijaKupca();
        kategorijaKupca = new KategorijaKupca();
    }

    @After
    public void tearDown() {
        soKreiraj = null;
        kategorijaKupca = null;
    }


    @Test
    public void testPreconditionIspravan() {
        kategorijaKupca.setNaziv("Premium");
        kategorijaKupca.setPopust(15);
        try {
            soKreiraj.precondition(kategorijaKupca);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak za ispravan parametar! " + ex.getMessage());
        }
    }

    @Test
    public void testPreconditionNull() {
        try {
            soKreiraj.precondition(null);
            fail("Trebalo je da baci izuzetak za null parametar!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testPreconditionPogresanTip() {
        try {
            soKreiraj.precondition("ovo nije KategorijaKupca");
            fail("Trebalo je da baci izuzetak za pogresan tip!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }


    @Test
    public void testKreirajUspesno() {
        KategorijaKupca nova = new KategorijaKupca("Dijamantski", 25);
        try {
            soKreiraj.execute(nova);
            // Nakon uspesnog insert-a, ID mora biti postavljen (veci od 0)
            assertTrue("ID mora biti postavljen nakon kreiranja!", nova.getIdKategorijaKupca() > 0);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak pri regularnom kreiranju! " + ex.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testKreirajNullBacaIzuzetak() throws Exception {
        soKreiraj.execute(null);
    }
}