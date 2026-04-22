package ui.logic;

import communication.Communication;
import java.util.ArrayList;
import model.*;
import model.communication.*;

public class UIController {
    private static UIController instance;

    private UIController() {
    }

    public static UIController getInstance() {
        if (instance == null) {
            instance = new UIController();
        }
        return instance;
    }

    public Pekar prijaviPekara(String korisnickoIme, String lozinka) throws Exception {
        Pekar pekar = new Pekar();
        pekar.setKorisnickoIme(korisnickoIme);
        pekar.setLozinka(lozinka);
        Request request = new Request(Operation.LOGIN, pekar);
        Response response = Communication.getInstance().prijaviPekara(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            return (Pekar) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void kreirajKategorijaKupca(KategorijaKupca kk) throws Exception {
        Request request = new Request(Operation.KREIRAJ_KATEGORIJA_KUPCA, kk);
        Response response = Communication.getInstance().kreirajKategorijaKupca(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public ArrayList<KategorijaKupca> vratiListuSviKategorijaKupca(KategorijaKupca kk) throws Exception {
        Request request = new Request(Operation.LISTA_SVI_KATEGORIJA_KUPCA, kk);
        Response response = Communication.getInstance().vratiListuSviKategorijaKupca(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS))
            return (ArrayList<KategorijaKupca>) response.getResult();
        throw response.getException();
    }

    public ArrayList<KategorijaKupca> vratiListuNekiKategorijaKupca(KategorijaKupca kk) throws Exception {
        Request request = new Request(Operation.LISTA_NEKI_KATEGORIJA_KUPCA, kk);
        Response response = Communication.getInstance().vratiListuSviKategorijaKupca(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS))
            return (ArrayList<KategorijaKupca>) response.getResult();
        throw response.getException();
    }

    public void obrisiKategorijaKupca(KategorijaKupca kk) throws Exception {
        Request request = new Request(Operation.OBRISI_KATEGORIJA_KUPCA, kk);
        Response response = Communication.getInstance().obrisiKategorijaKupca(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public void promeniKategorijaKupca(KategorijaKupca kk) throws Exception {
        Request request = new Request(Operation.PROMENI_KATEGORIJA_KUPCA, kk);
        Response response = Communication.getInstance().promeniKategorijaKupca(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public void kreirajPecivo(Pecivo p) throws Exception {
        Request request = new Request(Operation.KREIRAJ_PECIVO, p);
        Response response = Communication.getInstance().kreirajPecivo(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public ArrayList<Pecivo> vratiListuSviPecivo(Pecivo p) throws Exception {
        Request request = new Request(Operation.LISTA_SVI_PECIVO, p);
        Response response = Communication.getInstance().vratiListuSviPecivo(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS))
            return (ArrayList<Pecivo>) response.getResult();
        throw response.getException();
    }

    public ArrayList<Pecivo> vratiListuNekiPecivo(Pecivo p) throws Exception {
        Request request = new Request(Operation.LISTA_NEKI_PECIVO, p);
        Response response = Communication.getInstance().vratiListuSviPecivo(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS))
            return (ArrayList<Pecivo>) response.getResult();
        throw response.getException();
    }

    public void obrisiPecivo(Pecivo p) throws Exception {
        Request request = new Request(Operation.OBRISI_PECIVO, p);
        Response response = Communication.getInstance().obrisiPecivo(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public void promeniPecivo(Pecivo p) throws Exception {
        Request request = new Request(Operation.PROMENI_PECIVO, p);
        Response response = Communication.getInstance().promeniPecivo(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public void kreirajPekar(Pekar p) throws Exception {
        Request request = new Request(Operation.KREIRAJ_PEKAR, p);
        Response response = Communication.getInstance().kreirajPekar(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public ArrayList<Pekar> vratiListuSviPekar(Pekar p) throws Exception {
        Request request = new Request(Operation.LISTA_SVI_PEKAR, p);
        Response response = Communication.getInstance().vratiListuSviPekar(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS))
            return (ArrayList<Pekar>) response.getResult();
        throw response.getException();
    }

    public ArrayList<Pekar> vratiListuNekiPekar(Pekar p) throws Exception {
        Request request = new Request(Operation.LISTA_NEKI_PEKAR, p);
        Response response = Communication.getInstance().vratiListuSviPekar(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS))
            return (ArrayList<Pekar>) response.getResult();
        throw response.getException();
    }

    public void obrisiPekar(Pekar p) throws Exception {
        Request request = new Request(Operation.OBRISI_PEKAR, p);
        Response response = Communication.getInstance().obrisiPekar(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public void promeniPekar(Pekar p) throws Exception {
        Request request = new Request(Operation.PROMENI_PEKAR, p);
        Response response = Communication.getInstance().promeniPekar(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public void ubaciSertifikat(Sertifikat s) throws Exception {
        Request request = new Request(Operation.UBACI_SERTIFIKAT, s);
        Response response = Communication.getInstance().ubaciSertifikat(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public ArrayList<Sertifikat> vratiListuSviSertifikat(Sertifikat s) throws Exception {
        Request request = new Request(Operation.LISTA_SVI_SERTIFIKAT, s);
        Response response = Communication.getInstance().vratiListuSviSertifikat(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS))
            return (ArrayList<Sertifikat>) response.getResult();
        throw response.getException();
    }

    public ArrayList<Sertifikat> vratiListuNekiSertifikat(Sertifikat s) throws Exception {
        Request request = new Request(Operation.LISTA_NEKI_SERTIFIKAT, s);
        Response response = Communication.getInstance().vratiListuSviSertifikat(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS))
            return (ArrayList<Sertifikat>) response.getResult();
        throw response.getException();
    }

    public void obrisiSertifikat(Sertifikat s) throws Exception {
        Request request = new Request(Operation.OBRISI_SERTIFIKAT, s);
        Response response = Communication.getInstance().obrisiSertifikat(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public void promeniSertifikat(Sertifikat s) throws Exception {
        Request request = new Request(Operation.PROMENI_SERTIFIKAT, s);
        Response response = Communication.getInstance().promeniSertifikat(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public void kreirajKupac(Kupac k) throws Exception {
        Request request = new Request(Operation.KREIRAJ_KUPAC, k);
        Response response = Communication.getInstance().kreirajKupac(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public ArrayList<Kupac> vratiListuSviKupac(Kupac k) throws Exception {
        Request request = new Request(Operation.LISTA_SVI_KUPAC, k);
        Response response = Communication.getInstance().vratiListuSviKupac(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS))
            return (ArrayList<Kupac>) response.getResult();
        throw response.getException();
    }

    public ArrayList<Kupac> vratiListuNekiKupac(Kupac k) throws Exception {
        Request request = new Request(Operation.LISTA_NEKI_KUPAC, k);
        Response response = Communication.getInstance().vratiListuSviKupac(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS))
            return (ArrayList<Kupac>) response.getResult();
        throw response.getException();
    }

    public void obrisiKupac(Kupac k) throws Exception {
        Request request = new Request(Operation.OBRISI_KUPAC, k);
        Response response = Communication.getInstance().obrisiKupac(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public void promeniKupac(Kupac k) throws Exception {
        Request request = new Request(Operation.PROMENI_KUPAC, k);
        Response response = Communication.getInstance().promeniKupac(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public void kreirajRacun(Racun r) throws Exception {
        Request request = new Request(Operation.KREIRAJ_RACUN, r);
        Response response = Communication.getInstance().kreirajRacun(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public void promeniRacun(Racun r) throws Exception {
        Request request = new Request(Operation.PROMENI_RACUN, r);
        Response response = Communication.getInstance().promeniRacun(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public ArrayList<Racun> vratiListuSviRacun(Racun r) throws Exception {
        Request request = new Request(Operation.LISTA_SVI_RACUN, r);
        Response response = Communication.getInstance().vratiListuSviRacun(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS))
            return (ArrayList<Racun>) response.getResult();
        throw response.getException();
    }

    public ArrayList<Racun> vratiListuNekiRacun(Racun r) throws Exception {
        Request request = new Request(Operation.LISTA_NEKI_RACUN, r);
        Response response = Communication.getInstance().vratiListuSviRacun(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS))
            return (ArrayList<Racun>) response.getResult();
        throw response.getException();
    }
}
