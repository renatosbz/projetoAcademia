package com.company;

public class Cliente {
    private int matricula;
    private String nome;
    private boolean devedor;
    private double valorDeve;
    private String atividade;

    public Cliente (){
        this.matricula = -1; //construtor para inicializar o vetor com algo dentro e não dar null pointer.
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isDevedor() {

        if(this.valorDeve > 0 ){ //usa o valor que o cliente esta devendo pra verificar se ele é devedor ou nao
            setDevedor(true);
        }else{
            setDevedor(false);
        }

        return devedor;
    }

    public void setDevedor(boolean devedor) {
        this.devedor = devedor;
    }

    public double getValorDeve() {
        return valorDeve;
    }


    public void setValorDeve(double valorDeve) {
        this.valorDeve = valorDeve;
    }
}
