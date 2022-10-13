package Desafio2;

import java.util.HashMap;
import java.util.Map;

public class Principal {
    private static FileManager fileManager;
    private static Map<String, NumberArrayProcessor> counters;
    private static final String resourcesFolder = "Desafio2/";
    public static void main(String[] args) {
        fileManager = new FileManager();
        counters = new HashMap<>();

        //Pregunta 1
        final String LOTE01 = "lote01.txt";
//        constructCounter(LOTE01);
//        executeBruteForceCountForFile(LOTE01);

        //Pregunta 2
//        final String LOTE02 = "lote02.txt";
//        constructCounter(LOTE02);
//        executeBruteForceCountForFile(LOTE02);

        //Pregunta 4
        final String MSS01 = "mss01.txt";
//        constructCounter(MSS01);
//        long maxSumMss01 = counters.get(MSS01).cubicBruteForceMaxSubsequenceSum();
//        System.out.println("Max subsequence sum for mss01: " + maxSumMss01);

        //Pregunta 5
        final String MSS02 = "mss02.txt";
//        constructCounter(MSS02);
//        long maxSumMss02 = counters.get(MSS02).quadraticBruteForceMaxSubsequenceSum();
//        System.out.println("Max subsequence sum for mss02: " + maxSumMss02);


        //Pregunta 6
        final String MSS03 = "mss03.txt";
//        constructCounter(MSS03);
//        long maxSumMss03 = counters.get(MSS03).optimizedMaxSubsequenceSum();
//        System.out.println("Max subsequence sum for mss03: " + maxSumMss03);
    }

    public static void constructCounter(String fileName) {
        Integer[] arr = fileManager.extractIntArrayFromFile(resourcesFolder+fileName);
        System.out.println("Array length for file " + fileName + ": " + arr.length);
        counters.put(fileName, new NumberArrayProcessor(arr));
    }

    public static void executeBruteForceCountForFile(String fileName) {
        if (!counters.containsKey(fileName)) {
            System.out.println("Counters map does not contain counter for filename: " + fileName);
            return;
        }

        NumberArrayProcessor counter = counters.get(fileName);
        long cantInversiones = counter.bruteForceMaxInversionsCount();
        System.out.println("Inversiones in " + fileName + ": " + cantInversiones);
    }
}
