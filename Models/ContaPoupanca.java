package Models;

public class ContaPoupanca extends ContaBancaria implements tributavel {
    private double rendimentoMensal = 0.05; 
    double valorSaque;
    private double saldo = 0;
    private double depositar = 0;
 
    public ContaPoupanca(int agencia, String titular, int NumeroConta, String senha){
        super( agencia, titular, NumeroConta, senha); 
    }

    @Override 
    public void depositar(double valor){
        depositar = valor;
    }

    @Override
    public void saque(double valor){
        if (valor > depositar){
            System.out.println("Saldo insuficiente! ");
        }
        else {
            valorSaque = valor;
            saldo = depositar - valor;
        }
    }

    public void AplicarRendimentoMensal(){
        double rendimento = rendimentoMensal * saldo;
        System.out.println("O seu rendimento mensal foi de: R$ "+rendimento); 
    }

    @Override
    public void exibirSaldo(){
        System.out.println("----------------------");
        System.out.println("Titular: " + this.titular);
        System.out.println("Você tinha: R$ "+ depositar);
        System.out.println("Valor do saque: R$ "+ valorSaque); 
        System.out.println("O seu saldo é de: R$ "+ saldo);
    }

    @Override 
    public double calcularIR(){
        return depositar * 0.05; 
    }

}
