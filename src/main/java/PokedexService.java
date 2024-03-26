import java.sql.SQLException;

public class PokedexService {

    static java.sql.Connection connection;

    public static java.sql.Connection getConnection() {
        String host = "jdbc:sqlite:src/main/resources/pokedex.sqlite";
        if (connection == null) {
            try {
                connection = java.sql.DriverManager.getConnection(host);
            } catch (SQLException sql) {
                System.out.println(sql.getMessage());
                System.exit(0);
            }
        }
        return connection;
    }
}
