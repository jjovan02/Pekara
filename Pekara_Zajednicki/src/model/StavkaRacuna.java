package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StavkaRacuna implements OpstiDomenskiObjekat, Serializable {

    private int idRacun;
    private int rb;
    private double cena;
    private int kolicina;
    private double iznos;
    private Pecivo pecivo;
    private Racun racun;

    public StavkaRacuna() {
    }
    
    public StavkaRacuna(int idRacun, int rb, double cena,
            int kolicina, double iznos, Pecivo pecivo, Racun racun) {
        this.idRacun = idRacun;
        this.rb = rb;
        this.cena = cena;
        this.kolicina = kolicina;
        this.iznos = iznos;
        this.pecivo = pecivo;
        this.racun = racun;
    }

    

    public StavkaRacuna(double cena, int kolicina, double iznos, Pecivo pecivo) {
        this.cena = cena;
        this.kolicina = kolicina;
        this.iznos = iznos;
        this.pecivo = pecivo;
    }

    public int getIdRacun() {
        return idRacun;
    }

    public void setIdRacun(int idRacun) {
        this.idRacun = idRacun;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public Pecivo getPecivo() {
        return pecivo;
    }

    public void setPecivo(Pecivo pecivo) {
        this.pecivo = pecivo;
    }
    
    public Racun getRacun() { return racun; }
    
    public void setRacun(Racun racun) {
        this.racun = racun;
        this.idRacun = racun.getIdRacun();
    }

    @Override
    public String toString() {
        return "rb:" + rb + " | " + (pecivo != null ? pecivo.getNaziv() : "") + " | kol:" + kolicina + " | iznos:" + iznos;
    }

    @Override
    public String vratiVrednostiAtributa() {
        return idRacun + ", " + rb + ", " + cena + ", " + kolicina + ", " + iznos + ", " + pecivo.getIdPecivo();
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "cena = " + cena + ", kolicina = " + kolicina + ", iznos = " + iznos +
               ", idPecivo = " + pecivo.getIdPecivo();
    }

    @Override
    public String vratiImeKlase() {
        return "StavkaRacuna";
    }

    @Override
    public boolean napuni(ResultSet rs, ResultSet rs1) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public boolean napuni(ResultSet rs) {
        try {
            this.idRacun = rs.getInt("idRacun");
            this.rb = rs.getInt("rb");
            this.cena = rs.getDouble("cena");
            this.kolicina = rs.getInt("kolicina");
            this.iznos = rs.getDouble("iznos");
            this.pecivo = new Pecivo();
            this.pecivo.setIdPecivo(rs.getInt("idPecivo"));
            this.pecivo.setNaziv(rs.getString("nazivPecivo"));
            this.pecivo.setCena(rs.getDouble("cenaPecivo"));
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StavkaRacuna.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "idRacun = " + idRacun + " AND rb = " + rb;
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        StringBuilder sb = new StringBuilder(" WHERE 1=1");
        if (idRacun != 0)
            sb.append(" AND idRacun = ").append(idRacun);
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
        return "idRacun, rb, cena, kolicina, iznos, idPecivo";
    }

    @Override
    public void postaviID(int ID) {
        // composite key - not used
    }

    @Override
    public String vratiAlijas() {
        return "sr";
    }
    
    @Override
    public String vratiJoin() {
        return "JOIN Pecivo p ON sr.idPecivo = p.idPecivo";
    }

    @Override
    public String vratiSelectZaSlozeniSlog() {
        return "sr.*, p.naziv AS nazivPecivo, p.cena AS cenaPecivo, p.opis, p.rokTrajanja";
    }
    
}
