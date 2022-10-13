package Desafio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

//@TODO: Move class to a shared util module
public class FileManager
{
    public Integer[] extractIntArrayFromFile(String fileName) {
        System.out.println("Extracting array from file...");

        ArrayList<Integer> numberArray = new ArrayList<>();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File numberFile;
        try {
            numberFile = new File(Objects.requireNonNull(classLoader.getResource(fileName)).toURI());
        }
        catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        Scanner sc;
        try {
            sc = new Scanner(numberFile);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (sc.hasNextInt()) {
            Integer num = sc.nextInt();
            numberArray.add(num);
        }

        return numberArray.toArray(new Integer[] {});
    }
}
