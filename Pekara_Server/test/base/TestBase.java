
package base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import org.junit.BeforeClass;
import db.DbConnectionFactory;


public abstract class TestBase {

    protected static boolean initialized = false;

    @BeforeClass
    public static void init() throws Exception {

        Connection conn = DbConnectionFactory.getInstance().getConnection();

        if (!initialized) {
            initDatabase(conn);
            initialized = true;
        }
    }

    private static void initDatabase(Connection conn) throws Exception {
        try (BufferedReader reader = new BufferedReader(
                new FileReader("baza_memory.sql"))) {

            StringBuilder sql = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().startsWith("--")) {
                    sql.append(line).append("\n");
                }
            }

            for (String statement : sql.toString().split(";")) {
                String trimmed = statement.trim();
                if (!trimmed.isEmpty()) {
                    conn.createStatement().execute(trimmed);
                }
            }
            conn.commit();
            System.out.println("Memorijska baza uspesno inicijalizovana.");
        }
    }
}

