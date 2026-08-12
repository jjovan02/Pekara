package so.pecivo;

import java.util.ArrayList;
import model.Pecivo;
import so.OpstaSO;

public class KreirajPecivo extends OpstaSO<Void> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Pecivo)) {
            throw new Exception("Parametri nisu validni!");
        }

        Pecivo novoPecivo = (Pecivo) param;

        if (novoPecivo.getNaziv() == null || novoPecivo.getNaziv().trim().isEmpty()) {
            throw new Exception("Naziv peciva ne sme biti prazan!");
        }

        ArrayList<Pecivo> svaPeciva = dbr.vratiListuSvihSlogova(new Pecivo());

        for (Object obj : svaPeciva) {
            Pecivo p = (Pecivo) obj;

            if (p.getNaziv().equalsIgnoreCase(novoPecivo.getNaziv())) {
                throw new Exception("Pecivo sa nazivom \"" + novoPecivo.getNaziv() + "\" već postoji u sistemu!");
            }
        }
    }

    @Override
    protected Void executeOperation(Object param) throws Exception {
        Pecivo p = (Pecivo) param;
        dbr.pamtiSlog(p);
        return null;
    }
}