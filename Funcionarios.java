

public class Funcionarios {
    String nome;
    String cargo; 
    int idade; 
    private double salario;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Funcionarios(String nome, String cargo, int idade, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }
    
    @Override
    public String toString() {
        return this.nome + " - " + this.cargo + " - " + this.idade + " - " + this.salario;
    }

    
    
    
}
