package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pecivo implements OpstiDomenskiObjekat, Serializable {

    private int idPecivo;
    private String naziv;
    private String opis;
    private String rokTrajanja;
    private double cena;

    public Pecivo() {
    }

    public Pecivo(int idPecivo, String naziv, String opis, String rokTrajanja, double cena) {
        this.idPecivo = idPecivo;
        this.naziv = naziv;
        this.opis = opis;
        this.rokTrajanja = rokTrajanja;
        this.cena = cena;
    }

    public Pecivo(String naziv, String opis, String rokTrajanja, double cena) {
        this.naziv = naziv;
        this.opis = opis;
        this.rokTrajanja = rokTrajanja;
        this.cena = cena;
    }
    public int getIdPecivo() {
        return idPecivo;
    }

    public void setIdPecivo(int idPecivo) {
        this.idPecivo = idPecivo;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getRokTrajanja() {
        return rokTrajanja;
    }

    public void setRokTrajanja(String rokTrajanja) {
        this.rokTrajanja = rokTrajanja;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    

    @Override
    public String toString() {
        return idPecivo + "| " + naziv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pecivo)) return false;
        return this.idPecivo == ((Pecivo) o).idPecivo;
    }

    @Override
    public String vratiVrednostiAtributa() {
        return "'" + naziv + "', '" + opis + "', '" + rokTrajanja + "', " + cena;
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "naziv = '" + naziv + "', opis = '" + opis +
               "', rokTrajanja = '" + rokTrajanja + "', cena = " + cena;
    }

    @Override
    public String vratiImeKlase() {
        return "Pecivo";
    }

    @Override
    public boolean napuni(ResultSet rs, ResultSet rs1) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public boolean napuni(ResultSet rs) {
        try {
            this.idPecivo = rs.getInt("idPecivo");
            this.naziv = rs.getString("naziv");
            this.opis = rs.getString("opis");
            this.rokTrajanja = rs.getString("rokTrajanja");
            this.cena = rs.getDouble("cena");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Pecivo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "idPecivo = " + idPecivo;
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        StringBuilder sb = new StringBuilder(" WHERE 1=1");
        if (idPecivo != 0)
            sb.append(" AND idPecivo = ").append(idPecivo);
        if (naziv != null && !naziv.isEmpty())
            sb.append(" AND naziv LIKE '%").append(naziv).append("%'");
        if (cena != 0)
            sb.append(" AND cena = ").append(cena);
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
        return "naziv, opis, rokTrajanja, cena";
    }

    @Override
    public void postaviID(int ID) {
        setIdPecivo(ID);
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
