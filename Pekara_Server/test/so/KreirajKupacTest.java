package so;

import base.TestBase;
import model.Kupac;
import model.KategorijaKupca;
import model.Pekar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import so.kupac.KreirajKupac;


public class KreirajKupacTest extends TestBase {

    private KreirajKupac soKreiraj;
    private Kupac kupac;

    @Before
    public void setUp() {
        soKreiraj = new KreirajKupac();
        kupac = new Kupac();
    }

    @After
    public void tearDown() {
        soKreiraj = null;
        kupac = null;
    }


    @Test
    public void testPreconditionIspravan() {
        KategorijaKupca kk = new KategorijaKupca();
        kk.setIdKategorijaKupca(1);
        kupac.setIme("Marko");
        kupac.setPrezime("Markovic");
        kupac.setEmail("marko@gmail.com");
        kupac.setKategorijaKupca(kk);
        try {
            soKreiraj.precondition(kupac);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak za ispravan parametar! " + ex.getMessage());
        }
    }

    @Test
    public void testPreconditionNull() {
        try {
            soKreiraj.precondition(null);
            fail("Trebalo je da baci izuzetak!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testPreconditionPogresanTip() {
        try {
            soKreiraj.precondition(new Pekar());
            fail("Trebalo je da baci izuzetak!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }


    @Test
    public void testKreirajUspesno() {
        // KategorijaKupca sa ID=1 postoji u baza_memory.sql (ubacena u setUp)
        KategorijaKupca kk = new KategorijaKupca();
        kk.setIdKategorijaKupca(1);
        Kupac noviKupac = new Kupac("Nikola", "Nikolic", "nikola@gmail.com", kk);
        try {
            soKreiraj.execute(noviKupac);
            assertTrue("ID mora biti postavljen nakon kreiranja!", noviKupac.getIdKupac() > 0);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak pri regularnom kreiranju! " + ex.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testKreirajBezKategorijeBacaIzuzetak() throws Exception {
        Kupac losKupac = new Kupac("X", "Y", "z@z.com", null);
        soKreiraj.execute(losKupac);
    }

    @Test(expected = Exception.class)
    public void testKreirajNullBacaIzuzetak() throws Exception {
        soKreiraj.execute(null);
    }
}