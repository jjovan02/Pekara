package so;

import base.TestBase;
import model.Pekar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import so.pekar.KreirajPekar;

public class KreirajPekarTest extends TestBase {

    private KreirajPekar soKreiraj;

    @Before
    public void setUp() {
        soKreiraj = new KreirajPekar();
    }

    @After
    public void tearDown() {
        soKreiraj = null;
    }

    @Test
    public void testPreconditionIspravan() {
        Pekar p = new Pekar();
        p.setIme("Ana");
        p.setPrezime("Anic");
        p.setKorisnickoIme("aanic");
        p.setLozinka("ana123");
        p.setTelefon("0611234567");
        try {
            soKreiraj.precondition(p);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak za ispravan parametar! "
                    + ex.getMessage());
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
            soKreiraj.precondition(new Pekar());
            
        } catch (Exception ex) {
            assertNotNull(ex.getMessage());
        }
    }

    @Test
    public void testKreirajUspesno() {
        Pekar p = new Pekar();
        p.setIme("Stefan");
        p.setPrezime("Stefanovic");
        p.setKorisnickoIme("sstefan");
        p.setLozinka("stefan123");
        p.setTelefon("0621234567");
        try {
            soKreiraj.execute(p);
            assertTrue("ID mora biti postavljen nakon kreiranja!",
                    p.getIdPekar() > 0);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak! " + ex.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testKreirajNullBacaIzuzetak() throws Exception {
        soKreiraj.execute(null);
    }
}
