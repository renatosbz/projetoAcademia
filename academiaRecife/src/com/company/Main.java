package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Sistema sistema = new Sistema(); //cria um objeto da classe sistema pra usar as funções dentro dela
        Scanner entradaNumero = new Scanner(System.in);
        Scanner entradaLetras = new Scanner(System.in);
        Scanner entradaDouble = new Scanner(System.in);
        int escolha = 0;
        int ponteiro = 0; //ponteiro vai contar quantos clientes vão sendo adicionados no vetor e servir como matricula
        int matricula;
        String nome;
        String atividade;
        boolean devedor = false;
        double valorDeve = 0;
        while (escolha != 7) {
            System.out.println("Bem vindo ao menu da academia! Digite a opção desejada");
            System.out.println("1 - Adicionar novo cliente");
            System.out.println("2 - listar todos os clientes");
            System.out.println("3 - listar dados de clientes especifico");
            System.out.println("4 - listar quantidade de clientes em dia e quantidade de clientes devedores");
            System.out.println("5 - listar clientes devedores em ordem decrescente");
            System.out.println("6 - editar dados de um clientes");
            System.out.println("7 - sair do sistema");
            System.out.println();
            System.out.println("digite a opção desejada");
            escolha = entradaNumero.nextInt();
            switch (escolha) {
                case 1: // adicionar novo cliente
                    System.out.println("Adicione o nome do cliente");
                    nome = entradaLetras.next();
                    System.out.println("Qual atividade o cliente vai fazer?");
                    atividade = entradaLetras.next();
                    System.out.println("Quanto o cliente está devendo? Digite 0 caso ele não deva nada");
                    valorDeve = entradaDouble.nextDouble();
                    if (valorDeve > 0){
                        devedor = true;
                    } else{
                        devedor = false;
                    }
                    sistema.addClient(ponteiro, nome, devedor, valorDeve, atividade);


                    ponteiro = ponteiro +1;
                    System.out.println("Cliente adicionado com sucesso!");
                    System.out.println();

                    break;

                case 2: // listar todos os clientes
                   sistema.imprimeDadosTodosClientes();
                   break;

                case 3: // imprimir na tela todos os dados de cliente especifico
                    System.out.println("digite a matricula do cliente:");

                    sistema.imprimeClienteBusca(entradaNumero.nextInt());
                    break;

                case 4: // imprimir quant. clientes em dia e quant. clientes devendo
                    sistema.imprimeClientesDia();
                    break;

                case 5: //imprimir na tela a lista de clientes devedores
                    sistema.printDevedores();
                    break;

                case 6: //modificar dados de cliente
                    System.out.println("Insira o numero de matrícula cujo cadastro deseja alterar");
                    matricula = entradaNumero.nextInt();
                    System.out.println("Altere o nome do cliente");
                    nome = entradaLetras.next();
                    System.out.println("Altere a atividade");
                    atividade = entradaLetras.next();
                    System.out.println("Altere o valor que o cliente está devendo");
                    valorDeve = entradaDouble.nextDouble();
                    if (valorDeve > 0){
                        devedor = true;
                    } else{
                        devedor = false;
                    }
                    sistema.editaCliente(matricula, nome, devedor, valorDeve, atividade);
                    break;

                case 7: //retornar a tela inicial
                    System.out.println("saindo do sistema");
                    break;

                default:

            }


        }
    }
}
