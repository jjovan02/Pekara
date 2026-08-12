package so;

import base.TestBase;
import model.Pecivo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import so.pecivo.PromeniPecivo;

public class PromeniPecivoTest extends TestBase {

    private PromeniPecivo soPromeni;

    @Before
    public void setUp() {
        soPromeni = new PromeniPecivo();
    }

    @After
    public void tearDown() {
        soPromeni = null;
    }

    @Test
    public void testPreconditionIspravan() {
        Pecivo p = new Pecivo();
        p.setIdPecivo(1);
        p.setNaziv("Kifla specijal");
        p.setOpis("Specijalna kifla");
        p.setRokTrajanja("1 dan");
        p.setCena(60.0);
        try {
            soPromeni.precondition(p);
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
            soPromeni.precondition("nije pecivo");
            fail("Trebalo je da baci izuzetak za pogresan tip!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testPromeniUspesno() {
        // Menjamo Kroasan (ID=2) - postoji u bazi
        Pecivo p = new Pecivo();
        p.setIdPecivo(2);
        p.setNaziv("Kroasan masleni");
        p.setOpis("Kroasan sa maslacem");
        p.setRokTrajanja("2 dana");
        p.setCena(130.0);
        try {
            soPromeni.execute(p);
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