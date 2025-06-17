import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import lib.HandlerFile;
import model.entity.Paises;

public class SuperTrunfo {

    public static Scanner sc = new Scanner(System.in);

    public static Queue<Paises> jogador1 = new LinkedList<>();
    public static Queue<Paises> jogador2 = new LinkedList<>();

    public static String nomeJogador1;
    public static String nomeJogador2;

    public static void criarBaralho() {
        ArrayList<Paises> paises = HandlerFile.readFilePaises("ListaPaises.txt");

        Collections.shuffle(paises); // embaralha

        for (int i = 0; i < 5; i++) {
            jogador1.add(paises.get(i));
            paises.remove(i);
        }

        for (int i = 0; i < 5; i++) {
            jogador2.add(paises.get(i));
        }
    }

    public static int compararAtributos(int resposta) {

        System.out.println("\n---------------------------------------------------------------------------\n");
        System.out.println("                    CARTA JOGADOR 1:");
        jogador1.peek().imprimirPaises();
        System.out.println("\n---------------------------------------------------------------------------\n");
        System.out.println("                    CARTA JOGADOR 2:");
        jogador2.peek().imprimirPaises();

        if (resposta == 1) {

            if (jogador1.peek().getArea() > jogador2.peek().getArea()) {
                return 1;
            } else {
                return 2;
            }

        } else if (resposta == 2) {

            if (jogador1.peek().getPopulação() > jogador2.peek().getPopulação()) {
                return 1;
            } else {
                return 2;
            }

        } else if (resposta == 3) {

            if (jogador1.peek().getPib() > jogador2.peek().getPib()) {
                return 1;
            } else {
                return 2;
            }

        } else if (resposta == 4) {

            if (jogador1.peek().getExpectativaDeVida() > jogador2.peek().getExpectativaDeVida()) {
                return 1;
            } else {
                return 2;
            }

        } else if (resposta == 5) {

            if (jogador1.peek().getMedalhasOlimpicas() > jogador2.peek().getMedalhasOlimpicas()) {
                return 1;
            } else {
                return 2;
            }
        }
        return -1;
    }

    public static void gerarRodada() {
        int contador = 0;
        int resposta = 0;
        System.out.println("\n---------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------\n");
        System.out.println("CARTAS RESTANTES JOGADOR 1: " + jogador1.size());
        System.out.println("CARTAS RESTANTES JOGADOR 2: " + jogador2.size());
        System.out.println("\n---------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------\n");
        if (contador % 2 == 0) {
            System.out.println("Jogador 1, escolha o atributo que quer comparar na rodada");
            System.out.println("1.ÁREA\n2.POPULAÇÃO\n3.PIB\n4.EXPECTATIVA DE VIDA\n5.MEDALHAS OLÍMPICAS");
            resposta = sc.nextInt();
        } else {
            System.out.println("Jogador 2, escolha o atributo que quer comparar na rodada: ");
            System.out.println("1.ÁREA\n2.POPULAÇÃO\n3.PIB\n4.EXPECTATIVA DE VIDA\n5.MEDALHAS OLÍMPICAS");
            resposta = sc.nextInt();
        }

        if (compararAtributos(resposta) == 1) {
            System.out.println("\033[33m" + nomeJogador1 + " VENCEDOR!\033[0m\n");
            Paises aux = new Paises();
            aux = jogador2.poll();
            jogador1.add(aux);
            aux = jogador1.poll();
            jogador1.add(aux);
        } else {
            System.out.println("\033[33m" + nomeJogador2 + " VENCEDOR!\033[0m\n");
            Paises aux = new Paises();
            aux = jogador1.poll();
            jogador2.add(aux);
            aux = jogador2.poll();
            jogador2.add(aux);
        }
        contador++;
    }

    public static void imprimirCartas() {
        System.out.println("\n---------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------\n");
        System.out.println("                             \033[33mCARTAS JOGADOR 1:\033[0m\n ");
        System.out.println("\n---------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------\n");
        for (Paises paises : jogador1) {
            paises.imprimirPaises();
        }
        System.out.println("\n---------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------\n");
        System.out.println("                             \033[33mCARTAS JOGADOR 2:\033[0m\n ");
        System.out.println("\n---------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------\n");
        for (Paises paises : jogador2) {
            paises.imprimirPaises();
        }
    }

    public static void menu() {
        while (jogador1.size() > 0 && jogador2.size() > 0) {
            System.out.println("O que deseja fazer?\n1.JOGAR RODADA\n2.VER CARTAS\n0.SAIR");
            int escolha = sc.nextInt();
            switch (escolha) {
                case 1:
                    gerarRodada();
                    break;
                case 2:
                    imprimirCartas();
                    break;

                case 0:
                    jogador1.clear();
                    break;
                default:
                    break;
            }

        }
    }

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao jogo Super Trunfo!");

        System.out.print("Informe o nome do jogador 1: ");
        nomeJogador1 = sc.nextLine();

        System.out.print("Informe o nome do jogador 2: ");
        nomeJogador2 = sc.nextLine();
        criarBaralho();
        menu();

    }
}
