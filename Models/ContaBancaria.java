package Models;

public abstract class ContaBancaria {
    protected int agencia;
    public String titular; 
    protected int NumeroConta; 
    protected String senha; 
    protected double saldo;

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumeroConta() {
        return NumeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        NumeroConta = numeroConta;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ContaBancaria(int agencia, String titular, int NumeroConta, String senha) {
        this.agencia = agencia;
        this.titular = titular;
        this.NumeroConta = NumeroConta;
        this.senha = senha;
    }

    public abstract void saque(double valor);
    public abstract void depositar(double valor);
    

    public abstract void exibirSaldo();
        //System.out.println("----------------------");
        //System.out.println("Você tinha: R$ "+this.depositar);
        //System.out.println("Você sacou: R$ "+this.sacar);
        //System.out.println("Seu saldo é de: R$ "+(this.depositar-this.sacar));
    
}


