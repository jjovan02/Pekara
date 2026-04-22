package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sertifikat implements OpstiDomenskiObjekat, Serializable {

    private int idSertifikat;
    private String naziv;
    private String institucija;

    public Sertifikat() {
    }


    public Sertifikat(int idSertifikat, String naziv, String institucija) {
        this.idSertifikat = idSertifikat;
        this.naziv = naziv;
        this.institucija = institucija;
    }

    public Sertifikat(String naziv, String institucija) {
        this.naziv = naziv;
        this.institucija = institucija;
    }
    public int getIdSertifikat() {
        return idSertifikat;
    }

    public void setIdSertifikat(int idSertifikat) {
        this.idSertifikat = idSertifikat;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getInstitucija() {
        return institucija;
    }

    public void setInstitucija(String institucija) {
        this.institucija = institucija;
    }

    

    @Override
    public String toString() {
        return naziv + " (" + institucija + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sertifikat)) return false;
        return this.idSertifikat == ((Sertifikat) o).idSertifikat;
    }

    @Override
    public String vratiVrednostiAtributa() {
        return "'" + naziv + "', '" + institucija + "'";
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "naziv = '" + naziv + "', institucija = '" + institucija + "'";
    }

    @Override
    public String vratiImeKlase() {
        return "Sertifikat";
    }

    @Override
    public boolean napuni(ResultSet rs, ResultSet rs1) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public boolean napuni(ResultSet rs) {
        try {
            this.idSertifikat = rs.getInt("idSertifikat");
            this.naziv = rs.getString("naziv");
            this.institucija = rs.getString("institucija");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Sertifikat.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "idSertifikat = " + idSertifikat;
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        StringBuilder sb = new StringBuilder(" WHERE 1=1");
        if (idSertifikat != 0)
            sb.append(" AND idSertifikat = ").append(idSertifikat);
        if (naziv != null && !naziv.isEmpty())
            sb.append(" AND naziv LIKE '%").append(naziv).append("%'");
        if (institucija != null && !institucija.isEmpty())
            sb.append(" AND institucija LIKE '%").append(institucija).append("%'");
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
        return "naziv, institucija";
    }

    @Override
    public void postaviID(int ID) {
        setIdSertifikat(ID);
    }

    @Override
    public String vratiAlijas() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String vratiJoin() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String vratiSelectZaSlozeniSlog() {
        throw new UnsupportedOperationException("Not supported.");
    }
}
