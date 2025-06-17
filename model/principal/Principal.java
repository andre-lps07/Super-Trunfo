package model.principal;

import java.util.ArrayList;
import java.util.Scanner;

import model.dao.PaisesDAO;
import model.entity.Paises;

public class Principal {

    public static Scanner sc = new Scanner(System.in);

    public static ArrayList<Paises> pais = new ArrayList<>();

    public static void inserirPais() {

    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("QUAL AÇÃO DESEJA REALIZAR?");
            System.out.println("1.ADICIONAR PAÍS\n2.LISTAR PAÍSES\n0.SAIR");
            int resposta = sc.nextInt();
            sc.nextLine();
            if (resposta == 0) {
                break;
            }

            switch (resposta) {
                case 1:
                    Paises x = new Paises();
                    x.inserirPais();
                    pais.add(x);
                    break;

                case 3:
                    PaisesDAO.listarPaises();

                default:
                    break;
            }

        }
    }
}
