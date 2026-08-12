package so;

import base.TestBase;
import model.Kupac;
import model.KategorijaKupca;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import so.kupac.PromeniKupac;

public class PromeniKupacTest extends TestBase {

    private PromeniKupac soPromeni;

    @Before
    public void setUp() {
        soPromeni = new PromeniKupac();
    }

    @After
    public void tearDown() {
        soPromeni = null;
    }

    @Test
    public void testPreconditionIspravan() {
        KategorijaKupca kk = new KategorijaKupca();
        kk.setIdKategorijaKupca(1);
        Kupac k = new Kupac();
        k.setIdKupac(1);
        k.setIme("Petar");
        k.setPrezime("Petrovic Novi");
        k.setEmail("petar.novi@gmail.com");
        k.setKategorijaKupca(kk);
        try {
            soPromeni.precondition(k);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak! " + ex.getMessage());
        }
    }

    @Test
    public void testPreconditionNull() {
        try {
            soPromeni.precondition(null);
            fail("Trebalo je da baci izuzetak za null!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testPreconditionPogresanTip() {
        try {
            soPromeni.precondition("nije kupac");
            fail("Trebalo je da baci izuzetak za pogresan tip!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testPromeniUspesno() {
        KategorijaKupca kk = new KategorijaKupca();
        kk.setIdKategorijaKupca(2);
        Kupac k = new Kupac();
        k.setIdKupac(1);
        k.setIme("Petar");
        k.setPrezime("Petrovic Izmenjen");
        k.setEmail("petar.izmenjen@gmail.com");
        k.setKategorijaKupca(kk);
        try {
            soPromeni.execute(k);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak! " + ex.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testPromeniNullBacaIzuzetak() throws Exception {
        soPromeni.execute(null);
    }
}