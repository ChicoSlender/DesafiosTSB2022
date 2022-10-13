package Desafio1;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class Principal {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File lote01File;
        try {
            lote01File = new File(Objects.requireNonNull(classLoader.getResource("Desafio1/lote01.txt")).toURI());
        }
        catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        ListProcesor procesor = new ListProcesor();
        try {
            procesor.initArrayFromFile(lote01File);
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        System.out.println("First prime: " + procesor.getFirstPrime());
        System.out.println("Average of list: " + procesor.getAverage());
        int median = procesor.getMedian();
        System.out.println("Median: " + median);
        System.out.println("Percentage of elements lower than median: " + procesor.checkMedian(median) * 100 + "%");

        System.out.println("Find these numbers {2755145, 12873556, 9121687, 1013111, 882943, 923810, 716253, 987235}: " + procesor.findNumbers(new int[] {2755145, 12873556, 9121687, 1013111, 882943, 923810, 716253, 987235}));
        System.out.println("Max number in list: " + procesor.findMax());
    }

}
