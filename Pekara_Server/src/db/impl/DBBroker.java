package db.impl;

import db.DBRepository;
import db.DbConnectionFactory;
import model.OpstiDomenskiObjekat;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBBroker implements DBRepository<OpstiDomenskiObjekat, Long> {

    @Override
    public OpstiDomenskiObjekat vratiSlog(OpstiDomenskiObjekat odo) throws Exception {
        String upit = "SELECT * FROM " + odo.vratiImeKlase() + " WHERE " + odo.vratiUslovZaJednog();
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(upit);
            if (rs.next()) {
                odo.napuni(rs);
                st.close();
                return odo;
            } else {
                st.close();
                throw new Exception("Slog nije pronađen u tabeli " + odo.vratiImeKlase());
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Greška pri pristupu bazi: " + ex.getMessage(), ex);
        } catch (IOException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Greška pri konekciji: " + ex.getMessage(), ex);
        }
    }

    @Override
    public void pamtiSlog(OpstiDomenskiObjekat odo) throws Exception {
        String upit = "INSERT INTO " + odo.vratiImeKlase() +
                      " (" + odo.vratiNaziveAtributa() + ") " +
                      " VALUES(" + odo.vratiVrednostiAtributa() + ")";
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                odo.postaviID(rs.getInt(1));
            }
            rs.close();
            ps.close();
            System.out.println("Uspešno zapamćen slog u bazi");
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Greška pri upisu u bazu: " + ex.getMessage(), ex);
        } catch (IOException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Greška pri konekciji: " + ex.getMessage(), ex);
        }
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListuSlogovaKriterijum(OpstiDomenskiObjekat odo) throws Exception {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            String upit = "SELECT * FROM " + odo.vratiImeKlase() + odo.vratiUslovZaNadjiSlogove();
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                OpstiDomenskiObjekat novi = odo.getClass().getDeclaredConstructor().newInstance();
                novi.napuni(rs);
                lista.add(novi);
            }
            if (lista.isEmpty()) throw new Exception("Sistem nije pronašao ništa za zadate kriterijume!");
            st.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Greška pri pristupu bazi: " + ex.getMessage(), ex);
        } catch (IOException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Greška pri čitanju iz ResultSet-a: " + ex.getMessage(), ex);
        }
    }

    
    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListuSvihSlogova(OpstiDomenskiObjekat odo) throws Exception {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            String upit = "SELECT * FROM " + odo.vratiImeKlase();
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                OpstiDomenskiObjekat novi = odo.getClass().getDeclaredConstructor().newInstance();
                novi.napuni(rs);
                lista.add(novi);
            }
            if (lista.isEmpty()) throw new Exception("Sistem nije pronašao nijedan red u tabeli!");
            st.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Greška pri pristupu bazi: " + ex.getMessage(), ex);
        } catch (IOException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Greška pri čitanju iz ResultSet-a: " + ex.getMessage(), ex);
        }
    }

    @Override
    public void brisiSlog(OpstiDomenskiObjekat odo) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement st = connection.createStatement();
            String upit = "DELETE FROM " + odo.vratiImeKlase() + " WHERE " + odo.vratiUslovZaNadjiSlog();
            st.executeUpdate(upit);
            System.out.println("Uspesno obrisan slog u bazi.");
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Greška pri pristupu bazi: " + ex.getMessage(), ex);
        } catch (IOException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Greška pri konekciji: " + ex.getMessage(), ex);
        }
    }

    @Override
    public void promeniSlog(OpstiDomenskiObjekat odo) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement st = connection.createStatement();
            String upit = "UPDATE " + odo.vratiImeKlase() +
                          " SET " + odo.postaviVrednostiAtributa() +
                          " WHERE " + odo.vratiUslovZaNadjiSlog();
            st.executeUpdate(upit);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Greška pri pristupu bazi: " + ex.getMessage(), ex);
        } catch (IOException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Greška pri konekciji: " + ex.getMessage(), ex);
        }
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListuSlozenihSlogova(OpstiDomenskiObjekat odo) throws Exception {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        String upit = "SELECT " + odo.vratiSelectZaSlozeniSlog() + " FROM " + odo.vratiImeKlase() +
                      " " + odo.vratiAlijas() + " " + odo.vratiJoin() + odo.vratiUslovZaNadjiSlogove();
        System.out.println(upit);
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                OpstiDomenskiObjekat novi = odo.getClass().getDeclaredConstructor().newInstance();
                novi.napuni(rs);
                lista.add(novi);
            }
            if (lista.isEmpty()) throw new Exception("Sistem nije pronašao ništa za zadate kriterijume!");
            st.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Greška pri pristupu bazi: " + ex.getMessage(), ex);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new Exception("Greška pri čitanju iz ResultSet-a: " + ex.getMessage(), ex);
        }
    }
}
