package Desafio2;

import java.util.HashMap;
import java.util.Map;

public class Principal {
    private static FileManager fileManager;
    private static Map<String, ConteoInversiones> counters;
    private static final String resourcesFolder = "Desafio2/";
    public static void main(String[] args) {
        System.out.println("Desafio 2");
        fileManager = new FileManager();
        counters = new HashMap<>();

        //Pregunta 1
        final String LOTE01 = "lote01.txt";
        //constructCounter(LOTE01);
        //executeBruteForceCountForFile(LOTE01);

        //Pregunta 2
        final String LOTE02 = "lote02.txt";
        //constructCounter(LOTE02);
        //executeBruteForceCountForFile(LOTE02);
    }

    public static void constructCounter(String fileName) {
        Integer[] arr = fileManager.extractIntArrayFromFile(resourcesFolder+fileName);
        System.out.println("Array length for file " + fileName + ": " + arr.length);
        counters.put(fileName, new ConteoInversiones(arr));
    }

    public static void executeBruteForceCountForFile(String fileName) {
        if (!counters.containsKey(fileName)) {
            System.out.println("Counters map does not contain counter for filename: " + fileName);
            return;
        }

        ConteoInversiones counter = counters.get(fileName);
        int cantInversiones = counter.bruteForceCount();
        System.out.println("Inversiones in " + fileName + ": " + cantInversiones);
    }
}
