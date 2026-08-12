package so;

import base.TestBase;
import model.Pecivo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import so.pecivo.KreirajPecivo;

public class KreirajPecivoTest extends TestBase {

    private KreirajPecivo soKreiraj;

    @Before
    public void setUp() {
        soKreiraj = new KreirajPecivo();
    }

    @After
    public void tearDown() {
        soKreiraj = null;
    }

    @Test
    public void testPreconditionIspravan() {
        Pecivo p = new Pecivo();
        p.setNaziv("Burek");
        p.setOpis("Hrskavi burek");
        p.setRokTrajanja("1 dan");
        p.setCena(80.0);
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
            soKreiraj.precondition("ovo nije Pecivo");
            fail("Trebalo je da baci izuzetak za pogresan tip!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testKreirajUspesno() {
        Pecivo p = new Pecivo();
        p.setNaziv("Pogacica");
        p.setOpis("Domaca pogacica");
        p.setRokTrajanja("2 dana");
        p.setCena(60.0);
        try {
            soKreiraj.execute(p);
            assertTrue("ID mora biti postavljen nakon kreiranja!",
                    p.getIdPecivo() > 0);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak! " + ex.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testKreirajNullBacaIzuzetak() throws Exception {
        soKreiraj.execute(null);
    }
}