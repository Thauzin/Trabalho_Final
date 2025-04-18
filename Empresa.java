
import java.util.Scanner;
import java.util.stream.Collectors;

import Models.Funcionarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Empresa {
    String nome;
    String cnpj;
    int ContaEmail;
    String[] emails = new String[5];
    ArrayList<Funcionarios> funcionarios = new ArrayList<>();

    public Empresa(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public Empresa(String nome) {
        this.nome = nome;
    }

    public Empresa(){}




    public void cadastrarEmail(){
        if (ContaEmail == 5) {
            System.out.println("Lista de email cheia!");  
        }
        else{
            Scanner scanner = new Scanner(System.in);
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
}
