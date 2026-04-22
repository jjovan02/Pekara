package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PS implements OpstiDomenskiObjekat, Serializable {

    private Pekar pekar;
    private Sertifikat sertifikat;
    private LocalDate datumIzdavanja;

    public PS() {
    }

    public PS(Pekar pekar, Sertifikat sertifikat, LocalDate datumIzdavanja) {
        this.pekar = pekar;
        this.sertifikat = sertifikat;
        this.datumIzdavanja = datumIzdavanja;
    }

    public Pekar getPekar() { return pekar; }
    public void setPekar(Pekar pekar) { this.pekar = pekar; }
    public Sertifikat getSertifikat() { return sertifikat; }
    public void setSertifikat(Sertifikat sertifikat) { this.sertifikat = sertifikat; }
    public LocalDate getDatumIzdavanja() { return datumIzdavanja; }
    public void setDatumIzdavanja(LocalDate datumIzdavanja) { this.datumIzdavanja = datumIzdavanja; }

    @Override
    public String toString() {
        return (pekar != null ? pekar.getIme() + " " + pekar.getPrezime() : "") +
               " - " + (sertifikat != null ? sertifikat.getNaziv() : "") +
               " (" + datumIzdavanja + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PS)) return false;
        PS ps = (PS) o;
        return pekar != null && sertifikat != null &&
               pekar.getIdPekar() == ps.pekar.getIdPekar() &&
               sertifikat.getIdSertifikat() == ps.sertifikat.getIdSertifikat();
    }

    @Override
    public String vratiVrednostiAtributa() {
        return pekar.getIdPekar() + ", " + sertifikat.getIdSertifikat() +
               ", '" + datumIzdavanja.toString() + "'";
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "datumIzdavanja = '" + datumIzdavanja.toString() + "'";
    }

    @Override
    public String vratiImeKlase() {
        return "PS";
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
            this.pekar = p;

            Sertifikat s = new Sertifikat();
            s.setIdSertifikat(rs.getInt("s.idSertifikat"));
            s.setNaziv(rs.getString("nazivS"));
            s.setInstitucija(rs.getString("institucijaS"));
            this.sertifikat = s;

            this.datumIzdavanja = rs.getDate("ps.datumIzdavanja").toLocalDate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "idPekar = " + pekar.getIdPekar() +
               " AND idSertifikat = " + sertifikat.getIdSertifikat();
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        StringBuilder sb = new StringBuilder(" WHERE 1=1");
        if (pekar != null && pekar.getIdPekar() != 0)
            sb.append(" AND ps.idPekar = ").append(pekar.getIdPekar());
        if (sertifikat != null && sertifikat.getIdSertifikat() != 0)
            sb.append(" AND ps.idSertifikat = ").append(sertifikat.getIdSertifikat());
        if (datumIzdavanja != null)
            sb.append(" AND ps.datumIzdavanja = '").append(datumIzdavanja).append("'");
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
        return "idPekar, idSertifikat, datumIzdavanja";
    }

    @Override
    public void postaviID(int ID) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String vratiAlijas() {
        return "ps";
    }

    @Override
    public String vratiJoin() {
        return "JOIN Pekar pe ON ps.idPekar = pe.idPekar " +
               "JOIN Sertifikat s ON ps.idSertifikat = s.idSertifikat";
    }

    @Override
    public String vratiSelectZaSlozeniSlog() {
        return "ps.datumIzdavanja, " +
               "pe.idPekar, pe.ime AS imePe, pe.prezime AS prezimePe, " +
               "pe.korisnickoIme AS korisnickoImePe, pe.telefon AS telefonPe, " +
               "s.idSertifikat, s.naziv AS nazivS, s.institucija AS institucijaS";
    }
}