package so;

import base.TestBase;
import model.Pekar;
import model.Sertifikat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import so.sertifikat.UbaciSertifikat;

public class UbaciSertifikatTest extends TestBase {

    private UbaciSertifikat soUbaci;

    @Before
    public void setUp() {
        soUbaci = new UbaciSertifikat();
    }

    @After
    public void tearDown() {
        soUbaci = null;
    }

    @Test
    public void testPreconditionIspravan() {
        Sertifikat s = new Sertifikat();
        s.setNaziv("Poslastičar");
        s.setInstitucija("Kulinarski institut");
        try {
            soUbaci.precondition(s);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak za ispravan parametar! "
                    + ex.getMessage());
        }
    }

    @Test
    public void testPreconditionNull() {
        try {
            soUbaci.precondition(null);
            fail("Trebalo je da baci izuzetak za null parametar!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testPreconditionPogresanTip() {
        try {
            soUbaci.precondition(new Pekar());
            fail("Trebalo je da baci izuzetak za pogresan tip!");
        } catch (Exception ex) {
            assertEquals("Parametri nisu validni!", ex.getMessage());
        }
    }

    @Test
    public void testUbaciUspesno() {
        Sertifikat s = new Sertifikat();
        s.setNaziv("Tehnolog ishrane");
        s.setInstitucija("Tehnološki fakultet");
        try {
            soUbaci.execute(s);
            assertTrue("ID mora biti postavljen nakon kreiranja!",
                    s.getIdSertifikat() > 0);
        } catch (Exception ex) {
            fail("Nije trebalo da baci izuzetak! " + ex.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testUbaciNullBacaIzuzetak() throws Exception {
        soUbaci.execute(null);
    }
}