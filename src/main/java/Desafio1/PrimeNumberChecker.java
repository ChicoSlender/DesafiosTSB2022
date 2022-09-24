package Desafio1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrimeNumberChecker {
    List<Integer> primes;

    public PrimeNumberChecker() {
        this.primes = new ArrayList<>();
        this.primes.add(1); //Base case
    }

    public void generatePrimeNumbersUntil(int sup) {
        int inf;
        if (primes.isEmpty()) {
            inf = 1;
        }
        else {
            inf = primes.get(primes.size()-1) + 1;
        }

        for (int i = inf; i <= sup; i++) {
            if (this.isPrime(i)) {
                primes.add(i);
            }
        }
    }

    public boolean isPrime(int x) {
        if (this.primes.contains(x)) return true;

        int rootX = (int) Math.floor(Math.sqrt(x));
        this.generatePrimeNumbersUntil(rootX);

        Iterator<Integer> iterator = primes.listIterator();

        int currentPrime;
        while (iterator.hasNext()) {
            currentPrime = iterator.next();
            if (currentPrime > rootX) break;
            if (currentPrime == 1) continue;

            if (x % currentPrime == 0) return false;
        }

        return true;
    }
}
