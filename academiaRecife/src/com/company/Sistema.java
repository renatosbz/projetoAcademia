package com.company;

public class Sistema {
    Cliente[] vetor = new Cliente[20]; //array de 20 clientes

    public Sistema(){
        for (int i = 0; i< vetor.length; i++){ // inicializa os clientes usando o construtor
            vetor[i] = new Cliente();
        }
    }

    public void addClient (int matricula, String nome, boolean devedor, double valorDeve, String atividade){
        
        vetor[matricula].setMatricula(matricula);
        vetor[matricula].setNome(nome);
        vetor[matricula].setDevedor(devedor);
        vetor[matricula].setValorDeve(valorDeve);
        vetor[matricula].setAtividade(atividade);


    }

    public void imprimeDadosTodosClientes (){
        System.out.println("Essa é a lista de clientes: ");
        for (int i=0; i < this.vetor.length; i++){
            if( this.vetor[i].getMatricula() != -1) {
                System.out.println("matricula: " + this.vetor[i].getMatricula());
                System.out.println("nome: " + this.vetor[i].getNome());
                System.out.println("atividade: " + this.vetor[i].getAtividade());
            }
        }
    }

    public void imprimeClienteBusca ( int matricula){

        System.out.println("Esses são os dados do cliente " + matricula);
        System.out.println("Matricula: " + this.vetor[matricula].getMatricula());
        System.out.println("Nome: " + this.vetor[matricula].getNome());
        System.out.println("Atividade: " + this.vetor[matricula].getAtividade());
        if (this.vetor[matricula].isDevedor() == false){
            System.out.println("Está devendo? Não");
        } else{
            System.out.println("Está devendo? Sim");
        }
        System.out.println("Valor devido é: " + this.vetor[matricula].getValorDeve());
    }

    public void imprimeClientesDia(){
        int alunosDevedores=0;
        int alunosQuites=0;
        int tamanho = this.vetor.length;
        for (int i=0; i< tamanho; i++){
            if (this.vetor[i].isDevedor() == true){
                alunosDevedores = alunosDevedores+1;
            }
            else if (this.vetor[i].getMatricula() != -1){ //para nao contar os clientes inicializados mas n registrados como clientes de vdd
                alunosQuites = alunosQuites+1;
            }
        }
        System.out.println("Existem " +alunosQuites + " clientes em dia e "+ alunosDevedores + " clientes devendo.");
    }

    public void printDevedores(){//serve so pra imprimir o vetor de devedores. recebe o retorno do ordenaDevedores
        Cliente [] vDevedores;
        vDevedores = ordenaDevedores();

        System.out.println("Os clientes devedores são");
        for(int i=0; i< vDevedores.length; i++){
            System.out.println(vDevedores[i].getNome());
            System.out.println(vDevedores[i].getValorDeve());
        }


    }

    public Cliente[] ordenaDevedores(){
        int tamanho = this.vetor.length;
        int contador=0;

        for (int i=0; i < this.vetor.length; i++){ // esse for serve para contar quantos devedores tem no vetor original

            if (this.vetor[i].isDevedor() == true){
                contador = contador+1;

            }

        }

        Cliente[] listaDevedores = new Cliente[contador]; //cria um novo vetor do tamanho correto dos devedores
        int contador2 = 0;
        for (int i=0; i< this.vetor.length; i++){ //insere os dados dos devedores do vetor original no novo vetor
            if (this.vetor[i].isDevedor() == true){
                listaDevedores[contador2] = this.vetor[i];
                contador2 = contador2 +1;

            }
        }

        int iMax;
        Cliente vAux;

        for (int i = listaDevedores.length - 1; i > 0; i--){ //algoritimo de selection sort
            iMax = i;
            for (int j = 0; j < i; j++){
                if (listaDevedores[j].getValorDeve() < listaDevedores[iMax].getValorDeve()){

                    iMax = j;

                }
            }

            vAux = listaDevedores[iMax];
            listaDevedores[iMax] = listaDevedores[i];
            listaDevedores[i] = vAux;


        }

        return listaDevedores;
    }
    public void editaCliente (int matricula, String nome, boolean devedor, double valorDeve, String atividade){

        this.vetor[matricula].setNome(nome);
        this.vetor[matricula].setDevedor(devedor);
        this.vetor[matricula].setValorDeve(valorDeve);
        this.vetor[matricula].setAtividade(atividade);


    }



}
