package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Models.Funcionarios;
import Services.Empresa; 
import Models.Produto;

public class empresaDAO {
    
    private Connection connection; 

    public empresaDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserirFuncionario (Funcionarios funcionarios) throws SQLException {{
        String sql = "INSERT INTO funcionario (nome, idade, endereco, cargo, cpf, salario) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, funcionarios.getNome());
            stmt.setInt(2, funcionarios.getIdade());
            stmt.setString(3, funcionarios.getEndereco());
            stmt.setString(4, funcionarios.getCpf());
            stmt.setString(5, funcionarios.getCargo());
            stmt.setDouble(6, funcionarios.getSalario());

            stmt.executeUpdate();
        }
    } 

   
}

    public void inserirProduto (Produto produto) throws SQLException {{
        String sql = "INSERT INTO produto (codigo, nome, valor, quantidade) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, produto.getCodigo());
            stmt.setString(2, produto.getNome());
            stmt.setDouble(3, produto.getValor());
            stmt.setInt(4, produto.getQuantidade()); 

            stmt.executeUpdate();
        }
    }}

    public void exibirFuncionario() throws SQLException {
        String sql = "SELECT * FROM funcionario";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                String nome = resultado.getString("nome");
                int idade = resultado.getInt("idade");
                String endereco = resultado.getString("endereco");
                String cpf = resultado.getString("cpf");
                String cargo = resultado.getString("cargo");
                double salario = resultado.getDouble("salario");
                System.out.println("--------------------");
                System.out.println("Nome: " + nome);
                System.out.println("Idade: " + idade);
                System.out.println("Endereço: " + endereco);
                System.out.println("CPF: " + cpf);
                System.out.println("Cargo: " + cargo);
                System.out.println("Salário: " + salario);
            }
        }
    }

    public void deletarFuncionario(String cpf) throws SQLException {
        String sql = "DELETE FROM funcionario WHERE cpf = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0){
                System.out.println("Funcionario deletado com sucesso! ");
            }
            else{
                System.out.println("Funcionario não encontrado!");
            }
        }
    }

    public void deletarProduto(String codigo) throws SQLException {
        String sql = "DELETE FROM produto WHERE codigo = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0){
                System.out.println("Produto deletado com sucesso! ");
            }
            else{
                System.out.println("Produto não encontrado!");
            }
        }
    }
}
