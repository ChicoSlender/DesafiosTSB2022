package Desafio2;

public class NumberArrayProcessor {
    final private Integer[] array;
    private final int arrSize;

    public NumberArrayProcessor(Integer[] intArray) {
        this.array = intArray;
        this.arrSize = this.array.length;
    }

    /**
     * Brute force method to count the quantity of inversions in the array.
     * O(N^2)
     *
     * @return <b>int</b> quantity of inversions in the array
     * */
    public long bruteForceMaxInversionsCount() {
        System.out.println("Starting brute force count for array...");
        long counter = 0L;

        for (int i = 0; i < this.arrSize-1; i++) {
            for (int j = i+1; j < this.arrSize; j++) {
                if (this.array[i] > this.array[j])
                    counter++;
            }
        }

        return counter;
    }

    /**
     * Brute force method to get the max subsequence sum of the array.
     * O(N^2)
     *
     * @return <b>int</b> max subsequence sum of the array
     * */
    public long quadraticBruteForceMaxSubsequenceSum() {
        long maxSum = 0L;
        int sum;

        for (int i = 0; i < this.arrSize; i++) {
            sum = 0;
            for (int j = i; j < this.arrSize; j++) {
                sum += this.array[j];
                maxSum = Math.max(sum, maxSum);
            }

        }

        return maxSum;
    }

    /**
     * Brute force method to get the max subsequence sum of the array.
     * O(N^3)
     *
     * @return <b>int</b> max subsequence sum of the array
     * */
    public long cubicBruteForceMaxSubsequenceSum() {
        long maxSum = 0L;
        int sum;

        for (int i = 0; i < this.arrSize; i++) {
            for (int j = i; j < this.arrSize; j++) {
                sum = 0;

                for (int k = i; k <= j; k++) {
                    sum += this.array[k];
                }

                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum;
    }

    /**
     * Optimized method to get the max subsequence sum of the array.
     * O(N)
     *
     * @return <b>int</b> max subsequence sum of the array
     * */
    public long optimizedMaxSubsequenceSum() {
        long maxSum = 0L;
        int sum = 0;

        for (int i = 0; i < this.arrSize; i++) {
            sum += this.array[i];

            maxSum = Math.max(maxSum, sum);
            sum = Math.max(sum, 0);
        }

        return maxSum;
    }
}
