package Desafio2;

public class ConteoInversiones {
    final private Integer[] array;

    public ConteoInversiones(Integer[] intArray) {
        this.array = intArray;
    }

    public int bruteForceCount() {
        System.out.println("Starting brute force count for array...");
        int counter = 0;

        for (int i = 0; i < this.array.length-1; i++) {
            for (int j = i+1; j < this.array.length; j++) {
                if (this.array[i] > this.array[j])
                    counter++;
            }
        }

        return counter;
    }
}
