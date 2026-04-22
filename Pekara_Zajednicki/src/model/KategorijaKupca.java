package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KategorijaKupca implements OpstiDomenskiObjekat, Serializable {

    private int idKategorijaKupca;
    private String naziv;
    private int popust;

    public KategorijaKupca() {
    }


    public KategorijaKupca(int idKategorijaKupca, String naziv, int popust) {
        this.idKategorijaKupca = idKategorijaKupca;
        this.naziv = naziv;
        this.popust = popust;
    }

    public KategorijaKupca(String naziv, int popust) {
        this.naziv = naziv;
        this.popust = popust;
    }
    public int getIdKategorijaKupca() {
        return idKategorijaKupca;
    }

    public void setIdKategorijaKupca(int idKategorijaKupca) {
        this.idKategorijaKupca = idKategorijaKupca;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getPopust() {
        return popust;
    }

    public void setPopust(int popust) {
        this.popust = popust;
    }

    

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KategorijaKupca)) return false;
        return this.idKategorijaKupca == ((KategorijaKupca) o).idKategorijaKupca;
    }

    @Override
    public String vratiVrednostiAtributa() {
        return "'" + naziv + "', " + popust;
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "naziv = '" + naziv + "', popust = " + popust;
    }

    @Override
    public String vratiImeKlase() {
        return "KategorijaKupca";
    }

    @Override
    public boolean napuni(ResultSet rs, ResultSet rs1) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public boolean napuni(ResultSet rs) {
        try {
            this.idKategorijaKupca = rs.getInt("idKategorijaKupca");
            this.naziv = rs.getString("naziv");
            this.popust = rs.getInt("popust");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KategorijaKupca.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "idKategorijaKupca = " + idKategorijaKupca;
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        StringBuilder sb = new StringBuilder(" WHERE 1=1");
        if (idKategorijaKupca != 0)
            sb.append(" AND idKategorijaKupca = ").append(idKategorijaKupca);
        if (naziv != null && !naziv.isEmpty())
            sb.append(" AND naziv LIKE '%").append(naziv).append("%'");
        if (popust != 0)
            sb.append(" AND popust = ").append(popust);
        
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
        return "naziv, popust";
    }

    @Override
    public void postaviID(int ID) {
        setIdKategorijaKupca(ID);
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
