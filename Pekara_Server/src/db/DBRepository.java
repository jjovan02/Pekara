package db;

import model.OpstiDomenskiObjekat;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DBRepository<T, K> {

    default public void connect() throws SQLException, IOException {
        DbConnectionFactory.getInstance().getConnection();
    }

    default public void disconnect() throws SQLException, IOException {
        DbConnectionFactory.getInstance().getConnection().close();
    }

    default public void commit() throws SQLException, IOException {
        DbConnectionFactory.getInstance().getConnection().commit();
    }

    default public void rollback() throws SQLException, IOException {
        DbConnectionFactory.getInstance().getConnection().rollback();
    }

    void pamtiSlog(T t) throws Exception;
    T vratiSlog(T t) throws Exception;
    ArrayList<T> vratiListuSvihSlogova(T t) throws Exception;
    ArrayList<T> vratiListuSlogovaKriterijum(T t) throws Exception;
    void brisiSlog(T t) throws Exception;
    void promeniSlog(T t) throws Exception;
    ArrayList<T> vratiListuSlozenihSlogova(T t) throws Exception;
}
