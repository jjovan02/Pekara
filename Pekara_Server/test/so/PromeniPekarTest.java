package so;

import base.TestBase;
import model.Pekar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import so.pekar.PromeniPekar;

public class PromeniPekarTest extends TestBase {

    private PromeniPekar soPromeni;

    @Before
    public void setUp() {
        soPromeni = new PromeniPekar();
    }

    @After
    public void tearDown() {
        soPromeni = null;
    }

    @Test
    public void testPreconditionIspravan() {
        Pekar p = new Pekar();
        p.setIdPekar(1);
        p.setIme("Jovan");
        p.setPrezime("Janjusevic");
        p.setKorisnickoIme("jjovan02");
        p.setLozinka("jovan123");
        p.setTelefon("0641234567");
        try {
            soPromeni.precondition(p);
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
            soPromeni.precondition("nije pekar");
            fail("Trebalo je da baci izuzetak za pogresan tip!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testPromeniUspesno() {
        Pekar p = new Pekar();
        p.setIdPekar(1);
        p.setIme("Jovan");
        p.setPrezime("Janjusevic Izmenjen");
        p.setKorisnickoIme("jjovan02");
        p.setLozinka("novaLozinka123");
        p.setTelefon("0649999999");
        try {
            soPromeni.execute(p);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak! " + ex.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testPromeniNullBacaIzuzetak() throws Exception {
        soPromeni.execute(null);
    }
}