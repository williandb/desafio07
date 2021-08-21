package model;

import java.math.BigDecimal;

public class Funcionario {
    private Integer id;
    private String nome;
    private String cpf;
    private BigDecimal salario;

    public Funcionario(){
    }

    public Funcionario(Integer id, String nome, String cpf, BigDecimal salario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}
