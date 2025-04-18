package ContaBancaria;
public class app {
    public static void main(String[] args) {

        ContaCorrente conta1 = new ContaCorrente(100, 521, "Thauany", 145879, "123thauany");
        conta1.saque(20); 
        conta1.exibirSaldo();

        ContaPoupanca conta2 = new ContaPoupanca(2000, 722, "Paulo", 231548, "123Paulo");
        conta2.saque(1000);
        conta2.exibirSaldo();
        conta2.AplicarRendimentoMensal();

    }
}
