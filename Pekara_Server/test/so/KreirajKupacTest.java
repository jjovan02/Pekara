/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import model.Kupac;
import model.KategorijaKupca;
import model.Pekar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import so.kupac.KreirajKupac;

public class KreirajKupacTest {

    private KreirajKupac kreirajKupac;
    private Kupac kupac;

    @Before
    public void setUp() {
        kreirajKupac = new KreirajKupac();
        kupac = new Kupac();
    }

    @After
    public void tearDown() {
        kreirajKupac = null;
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
            kreirajKupac.precondition(kupac);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak za ispravan parametar!");
        }
    }

    @Test
    public void testPreconditionNull() {
        try {
            kreirajKupac.precondition(null);
            fail("Trebalo je da baci izuzetak!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testPreconditionPogresanTip() {
        try {
            kreirajKupac.precondition(new Pekar());
            fail("Trebalo je da baci izuzetak!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testIzvrsiOperacijuUspesno() {
        
        KategorijaKupca kk = new KategorijaKupca();
        kk.setIdKategorijaKupca(1);
        Kupac noviKupac = new Kupac(
            "Test", "Testovic", "test@test.com", kk);
        try {
            kreirajKupac.execute(noviKupac);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak: " + ex.getMessage());
        }
    }

    @Test
    public void testIzvrsiOperacijuNeuspesno() {

        Kupac losKupac = new Kupac("X", "Y", "z@z.com", null);
        try {
            kreirajKupac.execute(losKupac);
            fail("Trebalo je da baci izuzetak za kupca bez kategorije!");
        } catch (Exception ex) {
            assertNotNull(ex.getMessage());
        }
    }
}
