package Desafio1;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ListProcesor {
    private Integer[] numberArr;
    private Integer[] sortedNumberArr;
    private final PrimeNumberChecker primeCheker;
    public ListProcesor() {
        this.primeCheker = new PrimeNumberChecker();
    }

    public void initArrayFromFile(File file) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(file);

        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }

        this.numberArr = list.toArray(new Integer[] {});
        this.sortArray();
    }

    private void sortArray() {
        this.sortedNumberArr = Arrays.copyOf(this.numberArr, this.numberArr.length);
        Arrays.sort(sortedNumberArr);
    }

    public int getFirstPrime() {
        for (int currentNumber : this.numberArr) {
            if (this.primeCheker.isPrime(currentNumber))
                return currentNumber;
        }

        return -1;
    }

    public int getAverage() {
        if (this.numberArr.length == 0) return 0;

        long acum = 0;

        for (Integer integer : numberArr) {
            acum += integer;
        }

        long avg = acum / this.numberArr.length;
        float floatAvg = acum / (float) this.numberArr.length;
        System.out.println("Float average: " + floatAvg);

        return Math.round(avg);
    }

    public int getMedian() {
        int midIndex = this.sortedNumberArr.length / 2;
        float median;

        if (this.sortedNumberArr.length % 2 != 0) {
            median = this.sortedNumberArr[midIndex];
        }
        else {
            median = (this.sortedNumberArr[midIndex-1] + this.sortedNumberArr[midIndex]) / 2.0f;
        }

        return Math.round(median);
    }

    public float checkMedian(float median) {
        int lowerCount = 0;
        float size = this.numberArr.length;

        for (int num : this.numberArr) {
            if (num <= median) lowerCount++;
        }

        return lowerCount / size;
    }

    public String findNumbers(int[] numbers) {
        StringBuilder str = new StringBuilder();

        for (int number : numbers) {
            if (Arrays.binarySearch(this.sortedNumberArr, number) >= 0) {
                str.append("1");
            } else {
                str.append("0");
            }
        }

        return str.toString();
    }

    public int findMax() {
       return this.sortedNumberArr[this.sortedNumberArr.length-1];
    }
}
