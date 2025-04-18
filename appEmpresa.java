import java.util.Scanner;

import Models.Funcionarios;
import Services.Empresa;

public class appEmpresa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha uma opção: ");
        Empresa empresa = new Empresa();

        while (true){
            System.out.println("Escolha uma opção");
            System.out.println("1 - Cadastrar Email");
            System.out.println("2 - Cadastrar Funcionario");
            System.out.println("3 - Listar Email");
            System.out.println("4 - Listar Funcionarios");
            System.out.println("5 - Deletar Funcionarios");
            int opcao = scanner.nextInt();
            scanner.nextLine();


            switch (opcao) {
                case 1: 
                empresa.cadastrarEmail();
                break;

                case 2: 
                System.out.println("Nome do funcionario: ");
                String nome = scanner.nextLine();
                System.out.println("Cargo: ");
                String cargo = scanner.nextLine();
                System.out.println("Idade: ");
                int idade = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Salario: ");
                double salario = scanner.nextDouble();

                Funcionarios funcionario = new Funcionarios(nome, cargo, idade, salario);
                empresa.funcionarios.add(funcionario);
                break;

                case 3:
                empresa.listarEmail(); 
                break;

                case 4: 
                empresa.listarFuncionarios();

                case 5:
                System.out.println("Nome do funcionario: ");
                String nome1 = scanner.nextLine();
                empresa.DeletarFuncionario(nome1);

            }

             

       
        }
}
}
