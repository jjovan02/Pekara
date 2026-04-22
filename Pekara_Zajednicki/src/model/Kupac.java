package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Kupac implements OpstiDomenskiObjekat, Serializable {

    private int idKupac;
    private String ime;
    private String prezime;
    private String email;
    private KategorijaKupca kategorijaKupca;

    public Kupac() {
    }


    public Kupac(int idKupac, String ime, String prezime, String email, KategorijaKupca kategorijaKupca) {
        this.idKupac = idKupac;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.kategorijaKupca = kategorijaKupca;
    }

    public Kupac(String ime, String prezime, String email, KategorijaKupca kategorijaKupca) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.kategorijaKupca = kategorijaKupca;
    }
    public int getIdKupac() {
        return idKupac;
    }

    public void setIdKupac(int idKupac) {
        this.idKupac = idKupac;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public KategorijaKupca getKategorijaKupca() {
        return kategorijaKupca;
    }

    public void setKategorijaKupca(KategorijaKupca kategorijaKupca) {
        this.kategorijaKupca = kategorijaKupca;
    }

    

    @Override
    public String toString() {
        return idKupac + "| " + ime + " " + prezime;
    }

    @Override
    public String vratiVrednostiAtributa() {
        return "'" + ime + "', '" + prezime + "', '" + email + "', " + kategorijaKupca.getIdKategorijaKupca();
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "ime = '" + ime + "', prezime = '" + prezime +
               "', email = '" + email + "', idKategorijaKupca = " + kategorijaKupca.getIdKategorijaKupca();
    }

    @Override
    public String vratiImeKlase() {
        return "Kupac";
    }

    @Override
    public boolean napuni(ResultSet rs, ResultSet rs1) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public boolean napuni(ResultSet rs) {
        try {
            this.idKupac = rs.getInt("idKupac");
            this.ime = rs.getString("ime");
            this.prezime = rs.getString("prezime");
            this.email = rs.getString("email");
            this.kategorijaKupca = new KategorijaKupca();
            this.kategorijaKupca.setIdKategorijaKupca(rs.getInt("idKategorijaKupca"));
            this.kategorijaKupca.setNaziv(rs.getString("nazivKategorije"));
            this.kategorijaKupca.setPopust(rs.getInt("popust"));
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Kupac.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "idKupac = " + idKupac;
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        StringBuilder sb = new StringBuilder(" WHERE 1=1");
        if (idKupac != 0)
            sb.append(" AND idKupac = ").append(idKupac);
        if (ime != null && !ime.isEmpty())
            sb.append(" AND ime LIKE '%").append(ime).append("%'");
        if (prezime != null && !prezime.isEmpty())
            sb.append(" AND prezime LIKE '%").append(prezime).append("%'");
        if (email != null && !email.isEmpty())
            sb.append(" AND email LIKE '%").append(email).append("%'");
        if (kategorijaKupca != null && kategorijaKupca.getIdKategorijaKupca() != 0)
            sb.append(" AND kk.idKategorijaKupca = ").append(kategorijaKupca.getIdKategorijaKupca());
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
        return "ime, prezime, email, idKategorijaKupca";
    }

    @Override
    public void postaviID(int ID) {
        setIdKupac(ID);
    }

    @Override
    public String vratiAlijas() {
        return "k";
    }

    @Override
    public String vratiJoin() {
        return "JOIN KategorijaKupca kk ON k.idKategorijaKupca = kk.idKategorijaKupca";
    }

    @Override
    public String vratiSelectZaSlozeniSlog() {
        return "k.*, kk.naziv AS nazivKategorije, kk.popust";
    }
}
