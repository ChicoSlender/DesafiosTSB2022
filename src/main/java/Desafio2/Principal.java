package Desafio2;

import java.util.Arrays;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Desafio 2");
        FileManager fileManager = new FileManager();
        Integer[] arr = fileManager.extractIntArrayFromFile("Desafio2/lote01.txt");
        System.out.println(Arrays.toString(arr));
    }
}
