package factory1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectioFactory {

    // nome do usuario do banco de dados
    private static final String USERNAME = "root";

    // senha do usuario do banco de dados
    private static final String PASSWORD = "";
    
    //caminho do banco de dados
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/agenda";

    // conexao com o banco de dados
    private static java.sql.Connection connectionToMySQL() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return java.sql.DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException {
        java.sql.Connection connection = connectionToMySQL();
        if (connection != null) {
            System.out.println("Conexao com o banco de dados realizada com sucesso!");
        } else {
            System.out.println("Conexao com o banco de dados falhou!");
        }
        connection.close();
    }

    public static void closeConnection(Connection connection, PreparedStatement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connectionToMySQL();
    }

}
