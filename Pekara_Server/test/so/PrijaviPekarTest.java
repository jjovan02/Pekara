/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;



import model.Pekar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import so.pekar.PrijaviPekar;

/**
 *
 * @author stari
 */

public class PrijaviPekarTest {

    private PrijaviPekar prijaviPekar;
    private Pekar pekar;

    @Before
    public void setUp() {
        prijaviPekar = new PrijaviPekar();
        pekar = new Pekar();
    }

    @After
    public void tearDown() {
        prijaviPekar = null;
        pekar = null;
    }

    @Test
    public void testPreconditionIspravan() {
        pekar.setKorisnickoIme("admin");
        pekar.setLozinka("admin");
        try {
            prijaviPekar.precondition(pekar);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak za ispravan parametar!");
        }
    }

    @Test
    public void testPreconditionNull() {
        try {
            prijaviPekar.precondition(null);
            fail("Trebalo je da baci izuzetak!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testPreconditionPogresanTip() {
        try {
            prijaviPekar.precondition("ovo nije pekar");
            fail("Trebalo je da baci izuzetak!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testIzvrsiOperacijuUspesno() {
        pekar.setKorisnickoIme("jjovan02");
        pekar.setLozinka("jovan123");
        try {
            Pekar rezultat = (Pekar) prijaviPekar.execute(pekar);
            assertNotNull("Pekar ne sme biti null!", rezultat);
            assertEquals("jjovan02", rezultat.getKorisnickoIme());
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak: " + ex.getMessage());
        }
    }

    @Test
    public void testIzvrsiOperacijuNeuspesno() {
        pekar.setKorisnickoIme("nepostojeci_korisnik");
        pekar.setLozinka("pogresna_lozinka");
        Pekar rezultat = null;
        try {
            rezultat = (Pekar) prijaviPekar.execute(pekar);
        } catch (Exception ex) {
        }
        assertNull("Pekar mora biti null za neispravne podatke!", rezultat);
    }
}
