

import Models.ContaCorrente;
import Models.ContaPoupanca;

public class app {
    public static void main(String[] args) {

        ContaCorrente conta1 = new ContaCorrente( 521, "Thauany", 145879, "123thauany");
        conta1.depositar(200);
        conta1.saque(20); 
        conta1.exibirSaldo();

        ContaPoupanca conta2 = new ContaPoupanca( 722, "Paulo", 231548, "123Paulo");
        conta1 .depositar(2000);
        conta2.saque(1000);
        conta2.exibirSaldo();
        conta2.AplicarRendimentoMensal();

    }
}
