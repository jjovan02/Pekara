package so;

import base.TestBase;
import model.Pekar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import so.pekar.PrijaviPekar;


public class PrijaviPekarTest extends TestBase {

    private PrijaviPekar soPrijaviPekar;
    private Pekar pekar;

    @Before
    public void setUp() {
        soPrijaviPekar = new PrijaviPekar();
        pekar = new Pekar();
    }

    @After
    public void tearDown() {
        soPrijaviPekar = null;
        pekar = null;
    }


    @Test
    public void testPreconditionIspravan() {
        pekar.setKorisnickoIme("jjovan02");
        pekar.setLozinka("jovan123");
        try {
            soPrijaviPekar.precondition(pekar);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak za ispravan parametar! " + ex.getMessage());
        }
    }

    @Test
    public void testPreconditionNull() {
        try {
            soPrijaviPekar.precondition(null);
            fail("Trebalo je da baci izuzetak!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testPreconditionPogresanTip() {
        try {
            soPrijaviPekar.precondition("ovo nije Pekar");
            fail("Trebalo je da baci izuzetak!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }


    @Test
    public void testPrijaviUspesno() {
        pekar.setKorisnickoIme("jjovan02");
        pekar.setLozinka("jovan123");
        try {
            Pekar rezultat = (Pekar) soPrijaviPekar.execute(pekar);
            assertNotNull("Pekar ne sme biti null pri uspesnoj prijavi!", rezultat);
            assertEquals("Korisnicko ime mora odgovarati!", "jjovan02", rezultat.getKorisnickoIme());
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak pri ispravnim kredencijalima! " + ex.getMessage());
        }
    }

    @Test
    public void testPrijaviPogresniKredencijali() {
        pekar.setKorisnickoIme("nepostojeci_korisnik");
        pekar.setLozinka("pogresna_lozinka");
        Pekar rezultat = null;
        try {
            rezultat = (Pekar) soPrijaviPekar.execute(pekar);
        } catch (Exception ex) {
        }
        assertNull("Pekar mora biti null za neispravne podatke!", rezultat);
    }

    @Test(expected = Exception.class)
    public void testPrijaviNullBacaIzuzetak() throws Exception {
        soPrijaviPekar.execute(null);
    }
}