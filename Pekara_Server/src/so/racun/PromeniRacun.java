package so.racun;

import java.util.ArrayList;
import model.Racun;
import model.StavkaRacuna;
import model.Pecivo;
import so.OpstaSO;

public class PromeniRacun extends OpstaSO<Void> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Racun))
            throw new Exception("Parametri nisu validni!");
    }

    @Override
    protected Void executeOperation(Object param) throws Exception {
        Racun r = (Racun) param;

        StavkaRacuna filter = new StavkaRacuna();
        filter.setRacun(r);
        ArrayList<StavkaRacuna> stareStavke = dbr.vratiListuSlozenihSlogova(filter);
        for (StavkaRacuna s : stareStavke) {
            s.setRacun(r);
        }

        ArrayList<StavkaRacuna> noveStavke = r.getStavke();
        for (StavkaRacuna s : noveStavke) {
            s.setRacun(r);
        }

        for (StavkaRacuna stara : stareStavke) {
            boolean postojiUNovim = false;
            for (StavkaRacuna nova : noveStavke) {
                if (stara.getRacun().getIdRacun() == nova.getRacun().getIdRacun() && stara.getRb()== nova.getRb()) {
                    postojiUNovim = true;
                    dbr.brisiSlog(stara);
                    dbr.pamtiSlog(nova);
                    break;
                }
            }
            if (!postojiUNovim) {
                dbr.brisiSlog(stara);
            }
        }

        for (StavkaRacuna nova : noveStavke) {
            boolean postojiUStarim = false;
            for (StavkaRacuna stara : stareStavke) {
                if (stara.getRacun().getIdRacun() == nova.getRacun().getIdRacun() && stara.getRb()== nova.getRb()) {
                    postojiUStarim = true;
                    break;
                }
            }
            if (!postojiUStarim) {
                dbr.pamtiSlog(nova);
            }
        }

        dbr.promeniSlog(r);
        return null;
    }
}
