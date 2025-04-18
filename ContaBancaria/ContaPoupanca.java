

package ContaBancaria;
public class ContaPoupanca extends ContaBancaria implements tributavel {
    private double rendimentoMensal = 0.05; 
    double valorSaque;
    double saldo = 0;
    
    public ContaPoupanca(double depositar,int agencia, String titular, int NumeroConta, String senha){
        super(depositar, agencia, titular, NumeroConta, senha); 
    }

    @Override
    public void saque(double valor){
        if (valor > getDepositar()){
            System.out.println("Saldo insuficiente");
        }
        else {
            valorSaque = valor;
            saldo = getDepositar() - valor;
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
        System.out.println("Você tinha: R$ "+this.depositar);
        System.out.println("Valor do saque: R$ "+ valorSaque); 
        System.out.println("O seu saldo é de: R$ "+ saldo);
    }

    @Override 
    public double calcularIR(){
        return this.depositar * 0.05; 
    }

}
