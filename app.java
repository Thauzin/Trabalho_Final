import java.util.Scanner;
import Models.ContaCorrente;
import Models.ContaPoupanca;


public class app {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){ 
        System.out.println("Escolha uma opção: ");
        System.out.println("1 - Criar conta corrente ");
        System.out.println("2 - Criar conta poupança");
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
                break;
        }

        }
    }
}
