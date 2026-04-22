package controller;

import so.pekar.PrijaviPekar;
import so.pecivo.PromeniPecivo;
import so.pecivo.VratiListuSviPecivo;
import so.pecivo.KreirajPecivo;
import so.pecivo.VratiListuPecivo;
import so.pecivo.ObrisiPecivo;
import so.kategorijaKupca.VratiListuSviKategorijaKupca;
import so.kategorijaKupca.ObrisiKategorijaKupca;
import so.kategorijaKupca.VratiListuKategorijaKupca;
import so.kategorijaKupca.KreirajKategorijaKupca;
import so.kategorijaKupca.PromeniKategorijaKupca;
import so.sertifikat.VratiListuSviSertifikat;
import so.sertifikat.ObrisiSertifikat;
import so.sertifikat.PromeniSertifikat;
import so.sertifikat.UbaciSertifikat;
import so.sertifikat.VratiListuSertifikat;
import so.kupac.VratiListuKupac;
import so.kupac.KreirajKupac;
import so.kupac.VratiListuSviKupac;
import so.kupac.PromeniKupac;
import so.kupac.ObrisiKupac;
import so.pekar.VratiListuPekar;
import so.pekar.KreirajPekar;
import so.pekar.PromeniPekar;
import so.pekar.ObrisiPekar;
import so.pekar.VratiListuSviPekar;
import so.racun.KreirajRacun;
import so.racun.VratiListuRacun;
import so.racun.PromeniRacun;
import java.util.ArrayList;
import model.*;
import so.*;

public class Controller {
    private static Controller instance;
    private Pekar prijavljeni;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Pekar prijaviPekar(Pekar pekar) throws Exception {
        OpstaSO prijaviPekar = new PrijaviPekar();
        Pekar pekarP = (Pekar) prijaviPekar.execute(pekar);
        prijavljeni = pekarP;
        return pekarP;
    }

    public void kreirajKategorijaKupca(KategorijaKupca kk) throws Exception {
        new KreirajKategorijaKupca().execute(kk);
    }

    public ArrayList<KategorijaKupca> vratiListuSviKategorijaKupca(KategorijaKupca kk) throws Exception {
        return (ArrayList<KategorijaKupca>) new VratiListuSviKategorijaKupca().execute(kk);
    }

    public ArrayList<KategorijaKupca> vratiListuNekiKategorijaKupca(KategorijaKupca kk) throws Exception {
        return (ArrayList<KategorijaKupca>) new VratiListuKategorijaKupca().execute(kk);
    }

    public void obrisiKategorijaKupca(KategorijaKupca kk) throws Exception {
        new ObrisiKategorijaKupca().execute(kk);
    }

    public void promeniKategorijaKupca(KategorijaKupca kk) throws Exception {
        new PromeniKategorijaKupca().execute(kk);
    }

    public void kreirajPecivo(Pecivo p) throws Exception {
        new KreirajPecivo().execute(p);
    }

    public ArrayList<Pecivo> vratiListuSviPecivo(Pecivo p) throws Exception {
        return (ArrayList<Pecivo>) new VratiListuSviPecivo().execute(p);
    }

    public ArrayList<Pecivo> vratiListuNekiPecivo(Pecivo p) throws Exception {
        return (ArrayList<Pecivo>) new VratiListuPecivo().execute(p);
    }

    public void obrisiPecivo(Pecivo p) throws Exception {
        new ObrisiPecivo().execute(p);
    }

    public void promeniPecivo(Pecivo p) throws Exception {
        new PromeniPecivo().execute(p);
    }

    public void kreirajPekar(Pekar p) throws Exception {
        new KreirajPekar().execute(p);
    }

    public ArrayList<Pekar> vratiListuSviPekar(Pekar p) throws Exception {
        return (ArrayList<Pekar>) new VratiListuSviPekar().execute(p);
    }

    public ArrayList<Pekar> vratiListuNekiPekar(Pekar p) throws Exception {
        return (ArrayList<Pekar>) new VratiListuPekar().execute(p);
    }

    public void obrisiPekar(Pekar p) throws Exception {
        new ObrisiPekar().execute(p);
    }

    public void promeniPekar(Pekar p) throws Exception {
        new PromeniPekar().execute(p);
    }

    public void ubaciSertifikat(Sertifikat s) throws Exception {
        new UbaciSertifikat().execute(s);
    }

    public ArrayList<Sertifikat> vratiListuSviSertifikat(Sertifikat s) throws Exception {
        return (ArrayList<Sertifikat>) new VratiListuSviSertifikat().execute(s);
    }

    public ArrayList<Sertifikat> vratiListuNekiSertifikat(Sertifikat s) throws Exception {
        return (ArrayList<Sertifikat>) new VratiListuSertifikat().execute(s);
    }

    public void obrisiSertifikat(Sertifikat s) throws Exception {
        new ObrisiSertifikat().execute(s);
    }

    public void promeniSertifikat(Sertifikat s) throws Exception {
        new PromeniSertifikat().execute(s);
    }

    public void kreirajKupac(Kupac k) throws Exception {
        new KreirajKupac().execute(k);
    }

    public ArrayList<Kupac> vratiListuSviKupac(Kupac k) throws Exception {
        return (ArrayList<Kupac>) new VratiListuSviKupac().execute(k);
    }

    public ArrayList<Kupac> vratiListuNekiKupac(Kupac k) throws Exception {
        return (ArrayList<Kupac>) new VratiListuKupac().execute(k);
    }

    public void obrisiKupac(Kupac k) throws Exception {
        new ObrisiKupac().execute(k);
    }

    public void promeniKupac(Kupac k) throws Exception {
        new PromeniKupac().execute(k);
    }

    public void kreirajRacun(Racun r) throws Exception {
        r.setPekar(prijavljeni);
        new KreirajRacun().execute(r);
    }

    public ArrayList<Racun> vratiListuSviRacun(Racun r) throws Exception {
        return (ArrayList<Racun>) new VratiListuRacun().execute(r);
    }

    public ArrayList<Racun> vratiListuNekiRacun(Racun r) throws Exception {
        return (ArrayList<Racun>) new VratiListuRacun().execute(r);
    }

    public void promeniRacun(Racun r) throws Exception {
        new PromeniRacun().execute(r);
    }
}
