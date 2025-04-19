package Services;
import java.util.Scanner;
import java.util.stream.Collectors;
import Models.Funcionarios;
import Models.Produto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Empresa {
    String nome;
    String cnpj;
    int ContaEmail;
    String[] emails = new String[5];
    ArrayList<Funcionarios> funcionarios = new ArrayList<>();
    HashMap<Integer, Produto> produtos = new HashMap<>();


    public Empresa(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public Empresa(String nome) {
        this.nome = nome;
    }

    public Empresa(){}

    public ArrayList<Funcionarios> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionarios> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public String getNome() {
        return nome;
    }

    public String[] getEmails() {
        return emails;
    }


    public void cadastrarEmail(){
        if (ContaEmail == 5) {
            System.out.println("Lista de email cheia!");  
        }
        else{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nome da empresa: ");
            String nome = scanner.nextLine();
            for (int i =0; i < emails.length; i++){
                System.out.println("Digite o email ou digite nao para cancelar");
                String salvar = scanner.nextLine();
                if (salvar.equals("nao")){
                    break;
                }
                emails[i] = salvar;
                ContaEmail++;
            }
            
        }
    }

    public void listarEmail(){  
        System.out.println("Email: " + Arrays.toString(emails));
    }


    public void listarFuncionarios(){
        System.out.println("Funcionarios: "+funcionarios);
    }

    public void listarProdutos(){
        System.out.println("Produtos: "+produtos);
    }

    public void DeletarFuncionario(String nome) {
        List<Funcionarios> paraRemover = funcionarios.stream().filter(f -> f.getNome().equalsIgnoreCase(nome)).collect(Collectors.toList());

        if (paraRemover.isEmpty()) {
            System.out.println("Funcionário não encontrado");
        } 
        else {
            funcionarios.removeAll(paraRemover);
            System.out.println("Usuário(s) deletado(s) com sucesso!");
    }
    }

    public void ProdutoPorNome (String nome){
        List<Produto> achar = produtos.values().stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).toList();

        if (achar.isEmpty()) {
            System.out.println("Produto não encontrado");
        }
        else {
            System.out.println("Produto: " + achar.get(0).getNome());
            System.out.println("Valor do produto: " + achar.get(0).getValor());
            System.out.println("Quantidade em estoque " + achar.get(0).getQuantidade());
        }
    }

    public void ProdutoPorCodigo (int codigo){
        List<Produto> achar = produtos.values().stream().filter(p -> p.getCodigo() == (codigo)).toList();

        if (achar.isEmpty()) {
            System.out.println("Produto não encontrado");
        }
        else {
            System.out.println("Produto: " + achar.get(0).getNome());
            System.out.println("Valor do produto: " + achar.get(0).getValor());
            System.out.println("Quantidade em estoque " + achar.get(0).getQuantidade());
        }
    }

    public void ProdutoPorPreco (double preco){
        List<Produto> achar = produtos.values().stream().filter(p -> p.getValor() == (preco)).toList();

        if (achar.isEmpty()) {
            System.out.println("Produto não encontrado");
        }
        else {
            System.out.println("Produto: " + achar.get(0).getNome());
            System.out.println("Valor do produto: " + achar.get(0).getValor());
            System.out.println("Quantidade em estoque " + achar.get(0).getQuantidade());
        }
    }

  public HashMap<Integer, Produto> getProdutos() {
      return produtos;
  }

}
