package ifpb.dac.infra;

import ifpb.dac.domain.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 10/05/2018, 07:28:38
 */
public class ClientesEmJDBC {

    private Connection connection;
    private Statement statement;

    public ClientesEmJDBC() {
        iniciarConexao();
    }

    public void iniciarConexao() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection("jdbc:postgresql://host-banco:5432/clientes", "postgres", "123");
            
        } catch (Exception ex) {
            Logger.getLogger(ClientesEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Cliente> todos() {
        try {
            
            this.statement = this.connection.createStatement();
            ResultSet resultSet = this.statement.executeQuery("SELECT * FROM cliente;");
            List<Cliente> lista = new ArrayList<>();

            while (resultSet.next()) {
                lista.add(
                        Cliente.of(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("cpf"))
                );
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ArrayList<>();
    }

    public void salvar(Cliente cliente) {
        try {
            String sql = "INSERT INTO cliente(nome, cpf) VALUES (?,?)";
            PreparedStatement statements = this.connection.prepareStatement(sql);
            statements.setString(1, cliente.getNome());
            statements.setString(2, cliente.getCpf());
            statements.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
