package Models;


public class Funcionarios extends pessoa implements tributavel {
    protected String cargo;
    protected double salario;
    protected ContaBancaria contaSalario;

    public Funcionarios(String nome, int idade, String endereco, String cpf, String cargo, double salario) { 
        super(nome, idade, endereco, cpf);
        this.cargo = cargo;
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public double getSalario(double bonus) {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public ContaBancaria getContaSalario() {
        return contaSalario;
    }

    public void setContaSalario(ContaBancaria contaSalario) {
        this.contaSalario = contaSalario;
        contaSalario.depositar(salario);
    }

    @Override 
    public double calcularIR(){
        return salario * 0.05; 
    }


    
    
}
