package so;

import base.TestBase;
import model.KategorijaKupca;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import so.kategorijaKupca.PromeniKategorijaKupca;

public class PromeniKategorijaKupcaTest extends TestBase {

    private PromeniKategorijaKupca soPromeni;

    @Before
    public void setUp() {
        soPromeni = new PromeniKategorijaKupca();
    }

    @After
    public void tearDown() {
        soPromeni = null;
    }

    @Test
    public void testPreconditionIspravan() {
        KategorijaKupca kk = new KategorijaKupca();
        kk.setIdKategorijaKupca(1);
        kk.setNaziv("Redovan Plus");
        kk.setPopust(5);
        try {
            soPromeni.precondition(kk);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak za ispravan parametar! "
                    + ex.getMessage());
        }
    }

    @Test
    public void testPreconditionNull() {
        try {
            soPromeni.precondition(null);
            fail("Trebalo je da baci izuzetak za null parametar!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testPreconditionPogresanTip() {
        try {
            soPromeni.precondition("nije kategorija");
            fail("Trebalo je da baci izuzetak za pogresan tip!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testPromeniUspesno() {
        // Menjamo kategoriju sa ID=2 (VIP) - postoji u bazi
        KategorijaKupca kk = new KategorijaKupca();
        kk.setIdKategorijaKupca(2);
        kk.setNaziv("VIP Plus");
        kk.setPopust(15);
        try {
            soPromeni.execute(kk);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak pri promeni! "
                    + ex.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testPromeniNullBacaIzuzetak() throws Exception {
        soPromeni.execute(null);
    }
}