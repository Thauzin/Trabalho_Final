package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Models.ContaPoupanca;

public class ContaPoupancaDAO {
    
    private Connection connection;

    public ContaPoupancaDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserirConta(ContaPoupanca conta) throws SQLException {
        String sql = "INSERT INTO conta_poupanca (agencia, titular, NumeroConta, Senha, Saldo) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, conta.getAgencia());
            stmt.setString(2, conta.getTitular());
            stmt.setInt(3, conta.getNumeroConta());
            stmt.setString(4, conta.getSenha());
            stmt.setDouble(5, conta.getSaldo());

            stmt.executeUpdate();
        }
    }
}
