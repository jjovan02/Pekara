package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import konfiguracija.Konfiguracija;

public class DbConnectionFactory {
    
    private Connection connection;
    private static DbConnectionFactory instance;

    private DbConnectionFactory() {
    }

    public static DbConnectionFactory getInstance() {
        if (instance == null) {
            instance = new DbConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException, IOException {
        if (connection == null || connection.isClosed()) {
            Properties properties = new Properties();
            properties.load(new FileInputStream("config/dbconfig.properties"));

            String url = properties.getProperty(Konfiguracija.DB_CONFIG_URL);
            String user = properties.getProperty(Konfiguracija.DB_CONFIG_USERNAME);
            String password = properties.getProperty(Konfiguracija.DB_CONFIG_PASSWORD);

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Uspesno povezivanje sa bazom");
            connection.setAutoCommit(false);
        }
        return connection;
    }
}
