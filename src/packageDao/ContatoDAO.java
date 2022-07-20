package packageDao;

import factory1.ConnectioFactory;
import package1.Contato;

public class ContatoDAO {
    // CRUD - Create, Read, Update, Delete

    // Create
    public void create(Contato contato) {
        // criar a conexao com o banco de dados
        java.sql.Connection connection = ConnectioFactory.getConnection();
        // criar o comando SQL
        String sql = "INSERT INTO contatos (nome, telefone, register_date) VALUES (?, ?, ?)";
        // criar o statement
        java.sql.PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            // setar os valores
            statement.setString(1, contato.getNome());
            statement.setString(2, contato.getTelefone());
            statement.setDate(3, new java.sql.Date(contato.getRegister_date().getTime()));
            // executar o comando SQL
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            ConnectioFactory.closeConnection(connection, statement);
        }
    }

    // Read
    public Contato read(int id) {
        // criar a conexao com o banco de dados
        java.sql.Connection connection = ConnectioFactory.getConnection();
        // criar o comando SQL
        String sql = "SELECT * FROM contatos WHERE id = ?";
        // criar o statement
        java.sql.PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            // setar os valores
            statement.setInt(1, id);
            // executar o comando SQL
            java.sql.ResultSet resultSet = statement.executeQuery();
            // ler o resultado
            if (resultSet.next()) {
                Contato contato = new Contato();
                contato.setId(resultSet.getInt("id"));
                contato.setNome(resultSet.getString("nome"));
                contato.setTelefone(resultSet.getString("telefone"));
                contato.setRegister_date(resultSet.getDate("register_date"));
                return contato;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            ConnectioFactory.closeConnection(connection, statement);
        }
        return null;
    }

    // Update
    public void update(Contato contato) {
        // criar a conexao com o banco de dados
        java.sql.Connection connection = ConnectioFactory.getConnection();
        // criar o comando SQL
        String sql = "UPDATE contatos SET nome = ?, telefone = ?, register_date = ? WHERE id = ?";
        // criar o statement
        java.sql.PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            // setar os valores
            statement.setString(1, contato.getNome());
            statement.setString(2, contato.getTelefone());
            statement.setDate(3, new java.sql.Date(contato.getRegister_date().getTime()));
            statement.setInt(4, contato.getId());
            // executar o comando SQL
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            ConnectioFactory.closeConnection(connection, statement);
        }
    }

    // Delete
    public void delete(int id) {
        // criar a conexao com o banco de dados
        java.sql.Connection connection = ConnectioFactory.getConnection();
        // criar o comando SQL
        String sql = "DELETE FROM contatos WHERE id = ?";
        // criar o statement
        java.sql.PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            // setar os valores
            statement.setInt(1, id);
            // executar o comando SQL
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            ConnectioFactory.closeConnection(connection, statement);
        }
    }
}
