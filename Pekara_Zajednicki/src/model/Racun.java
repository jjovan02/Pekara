package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Racun implements OpstiDomenskiObjekat, Serializable {

    private int idRacun;
    private LocalDate datumIzdavanja;
    private int brojStavki;
    private double ukupanIznos;
    private String tipPlacanja;
    private int popust;
    private double iznosSaPopustom;
    private Pekar pekar;
    private Kupac kupac;
    private ArrayList<StavkaRacuna> stavke;


    public Racun(int idRacun, LocalDate datumIzdavanja, int brojStavki,
            double ukupanIznos, String tipPlacanja, int popust, double iznosSaPopustom,
            Pekar pekar, Kupac kupac, ArrayList<StavkaRacuna> stavke) {
        this.idRacun = idRacun;
        this.datumIzdavanja = datumIzdavanja;
        this.brojStavki = brojStavki;
        this.ukupanIznos = ukupanIznos;
        this.tipPlacanja = tipPlacanja;
        this.popust = popust;
        this.iznosSaPopustom = iznosSaPopustom;
        this.pekar = pekar;
        this.kupac = kupac;
        this.stavke = stavke;
    }
    

    public Racun() {
        stavke = new ArrayList<>();
    }
    public int getIdRacun() {
        return idRacun;
    }

    public void setIdRacun(int idRacun) {
        this.idRacun = idRacun;
    }

    public LocalDate getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(LocalDate datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public int getBrojStavki() {
        return brojStavki;
    }

    public void setBrojStavki(int brojStavki) {
        this.brojStavki = brojStavki;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public String getTipPlacanja() {
        return tipPlacanja;
    }

    public void setTipPlacanja(String tipPlacanja) {
        this.tipPlacanja = tipPlacanja;
    }

    public int getPopust() {
        return popust;
    }

    public void setPopust(int popust) {
        this.popust = popust;
    }

    public double getIznosSaPopustom() {
        return iznosSaPopustom;
    }

    public void setIznosSaPopustom(double iznosSaPopustom) {
        this.iznosSaPopustom = iznosSaPopustom;
    }

    public Pekar getPekar() {
        return pekar;
    }

    public void setPekar(Pekar pekar) {
        this.pekar = pekar;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public ArrayList<StavkaRacuna> getStavke() {
        return stavke;
    }

    public void setStavke(ArrayList<StavkaRacuna> stavke) {
        this.stavke = stavke;
    }

    

    public void izracunajIznose() {
        ukupanIznos = 0;
        for (StavkaRacuna s : stavke) {
            ukupanIznos += s.getIznos();
        }
        if (kupac != null && kupac.getKategorijaKupca() != null) {
            popust = kupac.getKategorijaKupca().getPopust();
        }
        iznosSaPopustom = ukupanIznos - ukupanIznos * popust / 100.0;
        brojStavki = stavke.size();
    }

    @Override
    public String toString() {
        return "Racun #" + idRacun + " | " + (kupac != null ? kupac.getIme() + " " + kupac.getPrezime() : "") + " | " + iznosSaPopustom + " RSD";
    }

    @Override
    public String vratiVrednostiAtributa() {
        return "'" + datumIzdavanja.toString() + "', " + brojStavki + ", " + ukupanIznos +
               ", '" + tipPlacanja + "', " + popust + ", " + iznosSaPopustom +
               ", " + pekar.getIdPekar() + ", " + kupac.getIdKupac();
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "datumIzdavanja = '" + datumIzdavanja.toString() + "', brojStavki = " + brojStavki +
               ", ukupanIznos = " + ukupanIznos + ", tipPlacanja = '" + tipPlacanja +
               "', popust = " + popust + ", iznosSaPopustom = " + iznosSaPopustom +
               ", idPekar = " + pekar.getIdPekar() + ", idKupac = " + kupac.getIdKupac();
    }

    @Override
    public String vratiImeKlase() {
        return "Racun";
    }

    @Override
    public boolean napuni(ResultSet rs, ResultSet rs1) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public boolean napuni(ResultSet rs) {
        try {
            Pekar p = new Pekar();
            p.setIdPekar(rs.getInt("pe.idPekar"));
            p.setIme(rs.getString("imePe"));
            p.setPrezime(rs.getString("prezimePe"));
            p.setKorisnickoIme(rs.getString("korisnickoImePe"));
            p.setTelefon(rs.getString("telefonPe"));

            Kupac k = new Kupac();
            k.setIdKupac(rs.getInt("ku.idKupac"));
            k.setIme(rs.getString("imeKu"));
            k.setPrezime(rs.getString("prezimeKu"));
            k.setEmail(rs.getString("emailKu"));

            this.idRacun = rs.getInt("r.idRacun");
            this.datumIzdavanja = rs.getDate("r.datumIzdavanja").toLocalDate();
            this.brojStavki = rs.getInt("r.brojStavki");
            this.ukupanIznos = rs.getDouble("r.ukupanIznos");
            this.tipPlacanja = rs.getString("r.tipPlacanja");
            this.popust = rs.getInt("r.popust");
            this.iznosSaPopustom = rs.getDouble("r.iznosSaPopustom");
            this.pekar = p;
            this.kupac = k;
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Racun.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "idRacun = " + idRacun;
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        StringBuilder sb = new StringBuilder(" WHERE 1=1");
        if (idRacun != 0)
            sb.append(" AND r.idRacun = ").append(idRacun);
        if (datumIzdavanja != null) {
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            sb.append(" AND r.datumIzdavanja = '").append(datumIzdavanja.format(f)).append("'");
        }
        if (pekar != null && pekar.getIdPekar() != 0)
            sb.append(" AND pe.idPekar = ").append(pekar.getIdPekar());
        if (pekar != null && pekar.getIme() != null && !pekar.getIme().isEmpty())
            sb.append(" AND pe.ime LIKE '%").append(pekar.getIme()).append("%'");
        if (pekar != null && pekar.getPrezime() != null && !pekar.getPrezime().isEmpty())
            sb.append(" AND pe.prezime LIKE '%").append(pekar.getPrezime()).append("%'");
        if (kupac != null && kupac.getIdKupac() != 0)
            sb.append(" AND ku.idKupac = ").append(kupac.getIdKupac());
        if (kupac != null && kupac.getIme() != null && !kupac.getIme().isEmpty())
            sb.append(" AND ku.ime LIKE '%").append(kupac.getIme()).append("%'");
        if (kupac != null && kupac.getPrezime() != null && !kupac.getPrezime().isEmpty())
            sb.append(" AND ku.prezime LIKE '%").append(kupac.getPrezime()).append("%'");
        
        return sb.toString();
    }

    @Override
    public String vratiAtributPretrazivanja() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String vratiUslovZaJednog() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String vratiNaziveAtributa() {
        return "datumIzdavanja, brojStavki, ukupanIznos, tipPlacanja, popust, iznosSaPopustom, idPekar, idKupac";
    }

    @Override
    public void postaviID(int ID) {
        setIdRacun(ID);
    }

    @Override
    public String vratiAlijas() {
        return "r";
    }

    @Override
    public String vratiJoin() {
        return "JOIN Pekar pe ON r.idPekar = pe.idPekar " +
               "JOIN Kupac ku ON r.idKupac = ku.idKupac";
    }

    @Override
    public String vratiSelectZaSlozeniSlog() {
        return "r.idRacun, r.datumIzdavanja, r.brojStavki, r.ukupanIznos, r.tipPlacanja, r.popust, r.iznosSaPopustom, " +
               "pe.idPekar, pe.ime AS imePe, pe.prezime AS prezimePe, pe.korisnickoIme AS korisnickoImePe, pe.telefon AS telefonPe, " +
               "ku.idKupac, ku.ime AS imeKu, ku.prezime AS prezimeKu, ku.email AS emailKu";
    }
}
