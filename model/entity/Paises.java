package model.entity;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;


public class Paises {

    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    private String nome;
    private int area; // em km²
    private double população;
    private double pib; // em bi
    private double expectativaDeVida;
    private int medalhasOlimpicas;
    private int id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getPopulação() {
        return população;
    }

    public void setPopulação(double população) {
        this.população = população;
    }

    public Double getPib() {
        return pib;
    }

    public void setPib(Double pib) {
        this.pib = pib;
    }

    public Double getExpectativaDeVida() {
        return expectativaDeVida;
    }

    public void setExpectativaDeVida(Double expectativaDeVida) {
        this.expectativaDeVida = expectativaDeVida;
    }

    public Integer getMedalhasOlimpicas() {
        return medalhasOlimpicas;
    }

    public void setMedalhasOlimpicas(Integer medalhasOlimpicas) {
        this.medalhasOlimpicas = medalhasOlimpicas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  void inserirPais() {
        System.out.print("Nome do país: ");
        String nome = sc.nextLine();
        this.setNome(nome);

        System.out.print("Área do país: ");
        int area = sc.nextInt();
        this.setArea(area);

        System.out.print("População do país: ");
        double população = sc.nextDouble();
        this.setPopulação(população);

        System.out.print("Pib do país: ");
        double pib = sc.nextDouble();
        this.setPib(pib);

        System.out.print("Expectativa de vida em média no país: ");
        double expectativaDeVida = sc.nextDouble();
        this.setExpectativaDeVida(expectativaDeVida);

        System.out.print("Número de medalhas olímpicas do país: ");
        int medalhasOlimpicas = sc.nextInt();
        this.setMedalhasOlimpicas(medalhasOlimpicas);

        sc.nextLine();
    }



public  void imprimirPaises(){
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("País: " + this.getNome());
        System.out.println("Área: " + df.format(this.getArea()) + " Km²");
        System.out.println("População: " + df.format(this.getPopulação()) + " habitantes");
        System.out.println("PIB: " + this.getPib() + " Bilhões");
        System.out.println("Expectativa de vida: " + this.getExpectativaDeVida() + " anos");
        System.out.println("Número de medalhas olímpicas: " + this.getMedalhasOlimpicas());
        System.out.println("---------------------------------------------------------------------------\n");
    }


}
