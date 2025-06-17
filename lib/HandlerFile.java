package lib;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import model.entity.Paises;

public class HandlerFile {



    public static void createFile(String filename) {
        try {

            File fileObj = new File(filename);

            if (fileObj.createNewFile()) {
                System.out.println("File created: " + fileObj.getName());
            } else {
                System.out.println("File already exists.");
            }

        } catch (IOException e) {

            System.out.println("An error occurred.");

            e.printStackTrace();
        }
    }

    public static void getFileInfo(String filename) {

        File myObj = new File(filename);

        if (myObj.exists()) {
            System.out.println("_____________________________________");
            System.out.println("File name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            System.out.println("Writeable: " + myObj.canWrite());
            System.out.println("Readable " + myObj.canRead());
            System.out.println("File size in bytes " + myObj.length());
            System.out.println("_____________________________________");
        } else {
            System.out.println("The file does not exist.");
        }
    }

    public static String getAbsolutePath(String filename) {

        File myObj = new File(filename);

        String pathAbs = null;

        if (myObj.exists()) {
            System.out.println("The file exist.");      
            pathAbs = myObj.getAbsolutePath();
            
        } else {
            System.out.println("The file does not exist.");
        }

        return pathAbs;
    }

    public static void deleteFile(String filename) {

        File myObj = new File(filename);

        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
        

    public static void fileWriterPaises(String filename, LinkedList<Paises> listaPaises) {
        try {

            FileWriter myWriter = new FileWriter(filename);

            for (int i = 0; i < listaPaises.size(); i++) {
                myWriter.write("Pais " + (i+1) +":\n");
                myWriter.write("Nome: " + listaPaises.get(i).getNome() + "\n");
                myWriter.write("Área: " + listaPaises.get(i).getArea() + "\n");
                myWriter.write("População: " +listaPaises.get(i).getPopulação() + "\n");
                myWriter.write("PIB: " + listaPaises.get(i).getPib() + "\n");
                myWriter.write("Expectativa de vida: " + listaPaises.get(i).getExpectativaDeVida() + "\n");
                myWriter.write("Medalhas Olímpicas: " + listaPaises.get(i).getMedalhasOlimpicas() + "\n");
            }

            myWriter.close();

            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static ArrayList<Paises> readFilePaises(String filename) {
        ArrayList<Paises> listaPaises = new ArrayList<>();
        
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine(); // Lê uma linha com o nome do país

                Paises pais = new Paises();
                
                pais.setNome(data);  

                if (myReader.hasNextLine()) {
                    pais.setArea(Integer.parseInt(myReader.nextLine().trim()));
                }

                if (myReader.hasNextLine()) {
                    pais.setPopulação(Double.parseDouble(myReader.nextLine().trim())); 
                }

                if (myReader.hasNextLine()) {
                    pais.setPib(Double.parseDouble(myReader.nextLine().trim())); 
                }

                if (myReader.hasNextLine()) {
                    pais.setExpectativaDeVida(Double.parseDouble(myReader.nextLine().trim()));           
                     }

                if (myReader.hasNextLine()) {
                    pais.setMedalhasOlimpicas(Integer.parseInt(myReader.nextLine().trim()));  
                }

                listaPaises.add(pais);
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return listaPaises;
    }

  
}