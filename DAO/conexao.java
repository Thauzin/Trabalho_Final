package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/POO"; 
        String usuario = "vscode_user"; 
        String senha = "senha123"; 

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado ao banco de dados com sucesso!");
            return conexao;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
