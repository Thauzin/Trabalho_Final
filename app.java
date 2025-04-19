import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import DAO.ContaCorrenteDAO;
import DAO.ContaPoupancaDAO;
import Models.ContaCorrente;
import Models.ContaPoupanca;
import Models.Funcionarios;
import DAO.ContaCorrenteDAO;
import DAO.conexao; 
import Services.Empresa;
import DAO.empresaDAO;
import Models.Produto;



public class app {
    public static void main(String[] args) throws SQLException{
        Scanner scanner = new Scanner(System.in);
        Connection conn = conexao.getConnection(); 
        Empresa empresa = new Empresa();


        while (true){ 
        System.out.println("Escolha uma opção: ");
        System.out.println("1 - Criar conta corrente ");
        System.out.println("2 - Criar conta poupança");
        System.out.println("3 - Cadastrar Email");
        System.out.println("4 - Cadastrar Funcionario");
        System.out.println("5 - Cadastrar Produtos");
        System.out.println("6 - Listar Email");
        System.out.println("7 - Listar Funcionarios");
        System.out.println("8 - Listar todos os Produtos"); 
        System.out.println("9 - Achar produto"); 
        System.out.println("10 - Demitir Funcionarios");
        System.out.println("11 - Deletar Produto");
        System.out.println("12 - Fazer pagamento funcionarios");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1: 
                System.out.println("Criar conta corrente");
                System.out.println("Titular: ");
                String titular = scanner.next();
                System.out.println("Agencia: ");
                int agencia = scanner.nextInt();
                System.out.println("Número da conta: ");
                int numeroConta = scanner.nextInt();
                System.out.println("Senha: ");
                String senha = scanner.next();
                ContaCorrente conta1 = new ContaCorrente(agencia, titular, numeroConta, senha);
                System.out.println("Conta criada com sucesso!");
                int opcao2 = 0;
                while (opcao2 != 3){
                    System.out.println("1 - Depositar | 2 - Sacar | 3 - Sair");
                    opcao2 = scanner.nextInt();
                    if (opcao2 == 1) {
                        System.out.println("Valor a ser depositado: ");
                        double valor = scanner.nextDouble();
                        conta1.depositar(valor);
                    }
                    else if (opcao2 == 2) {
                        System.out.println("Valor a ser sacado: ");
                        double valor1 = scanner.nextDouble();
                        conta1.saque(valor1);
                    }
                    else if (opcao2 == 3){
                        break;
                    }
                }
                conta1.exibirSaldo();
                ContaCorrenteDAO dao = new ContaCorrenteDAO(conn);
                dao.inserirConta(conta1); 
                break;

                case 2: 
                System.out.println("Criar conta Poupança");
                System.out.println("Titular: ");
                String titular1 = scanner.next();
                System.out.println("Agencia: ");
                int agencia1 = scanner.nextInt();
                System.out.println("Número da conta: ");
                int numeroConta1 = scanner.nextInt();
                System.out.println("Senha: ");
                String senha1 = scanner.next();
                ContaPoupanca conta2 = new ContaPoupanca(agencia1, titular1, numeroConta1, senha1);
                System.out.println("Conta criada com sucesso!");
                int opcao3 = 0;
                while (opcao3 != 4){
                    System.out.println("1 - Depositar | 2 - Sacar | 3 - Aplicar Rendimento | 4 - Sair");
                    opcao3 = scanner.nextInt();
                    if (opcao3 == 1) {
                        System.out.println("Valor a ser depositado: ");
                        double valor = scanner.nextDouble();
                        conta2.depositar(valor);
                    }
                    else if (opcao3 == 2) {
                        System.out.println("Valor a ser sacado: ");
                        double valor1 = scanner.nextDouble();
                        conta2.saque(valor1);
                    }
                    else if(opcao3 == 3){
                        conta2.AplicarRendimentoMensal();
                    }
                    else if (opcao3 == 4){
                        break;
                    }
                }
                conta2.exibirSaldo();
                ContaPoupancaDAO dao2 = new ContaPoupancaDAO(conn);
                dao2.inserirConta(conta2); 
                
                break;

                case 3: 
                empresa.cadastrarEmail();
                break;

                case 4: 
                System.out.println("Cadastrar funcionario");
                scanner.nextLine();
                System.out.println("Nome do funcionario: ");
                String nome = scanner.nextLine();
                System.out.println("Idade: ");
                int idade = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Salario: ");
                double salario = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Endereco: ");
                String endereco = scanner.nextLine();
                System.out.println("CPF: ");
                String cpf = scanner.nextLine();
                System.out.println("Cargo: ");
                String cargo = scanner.nextLine();

                Funcionarios funcionario = new Funcionarios(nome, idade, endereco, cargo, cpf, salario);
                empresa.getFuncionarios().add(funcionario);
                empresaDAO dao1 = new empresaDAO(conn);
                dao1.inserirFuncionario(funcionario);

                break;

                case 5: 
                System.out.println("Cadastrar Produto");
                scanner.nextLine();
                System.out.println("Codigo: ");
                int codigo = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Nome do produto: ");
                String nomeProduto = scanner.nextLine();
                System.out.println("Preco: ");
                double preco = scanner.nextDouble();
                System.out.println("Quantidade em estoque: ");
                int estoque = scanner.nextInt();
                Produto produto = new Produto(codigo, nomeProduto, preco, estoque);
                empresa.getProdutos().put(codigo, produto); 
                empresaDAO dao5 = new empresaDAO(conn);
                dao5.inserirProduto(produto);

                break;

                case 6:
                empresa.listarEmail(); 
                break;

                case 7: 
                // empresa.listarFuncionarios();
                empresaDAO dao3 = new empresaDAO(conn);
                dao3.exibirFuncionario();
                break;

                case 8:
                empresa.listarProdutos(); 
                break;

                case 9:
                System.out.println("1 - Achar produto por nome");
                System.out.println("2 - Achar produto por codigo");
                System.out.println("3 - Achar produto por preço");
                int opcao5 = scanner.nextInt();

                if (opcao5 == 1) {
                    System.out.println("Achar produto por nome");
                    scanner.nextLine();
                    System.out.println("Nome do produto: ");
                    String nomeProduto2 = scanner.nextLine();
                    empresa.ProdutoPorNome(nomeProduto2);
                    break;
                }

                else if (opcao5 == 2){
                    System.out.println("Achar produto por codigo");
                    scanner.nextLine();
                    System.out.println("Codigo do produto: ");
                    int codigo2 = scanner.nextInt();
                    empresa.ProdutoPorCodigo(codigo2);
                    break;
                }

                else if (opcao5 == 3){
                    System.out.println("Achar produto por preco");
                    scanner.nextLine();
                    System.out.println("Preco do produto: ");
                    double preco2 = scanner.nextDouble();
                    empresa.ProdutoPorPreco(preco2);
                    break;
                }

                break;

                case 10:
                System.out.println("Demitir funcionario");
                scanner.nextLine();
                System.out.println("CPF do funcionario: ");
                String cpf1 = scanner.nextLine();
                //empresa.DeletarFuncionario(nome1);
                empresaDAO dao4 = new empresaDAO(conn);
                dao4.deletarFuncionario(cpf1);
                break;

                case 11:
                System.out.println("Deletar Produto");
                scanner.nextLine();
                System.out.println("Codigo do produto: ");
                String cod = scanner.nextLine();
                empresaDAO dao7 = new empresaDAO(conn);
                dao7.deletarProduto(cod);
                break;

                case 12:
                empresaDAO dao8 = new empresaDAO(conn);
                dao8.pagarTodosFuncionarios();
        }
        }
    }
    
}
