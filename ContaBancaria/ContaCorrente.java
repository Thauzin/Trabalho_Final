package ContaBancaria;
public class ContaCorrente extends ContaBancaria {

    double tarifa = 10;

    public ContaCorrente(double depositar, int agencia, String titular, int NumeroConta, String senha){ 
        super(depositar, agencia, titular, NumeroConta, senha); 
    }

    @Override 
    public void saque(double valor){
        if (valor > getDepositar()){
            System.out.println("Saldo insuficiente");
        }
        else{
            tarifa = valor + 10;
        }
    }

    public void exibirSaldo(){
        System.out.println("----------------------");
        System.out.println("Titular: " + this.titular);
        System.out.println("Você tinha: R$ "+this.depositar);
        System.out.println("O valor da tarifa é de: R$ 10.00");
        System.out.println("Valor do saque (com tarifa inclusa): R$ "+ tarifa);
        System.out.println("O seu saldo é de: R$ "+(this.depositar-this.tarifa));
    }
}