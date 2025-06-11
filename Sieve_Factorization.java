import java.util.*;
public class Sieve_Factorization {
static int[] spf = new int[1_000_001]; 

public static void sieve() {
    int maxN = 1_000_000;

    for (int i = 2; i <= maxN; i++) {
        if (spf[i] == 0) { // i is prime
            spf[i] = i;
            for (long j = (long) i * i; j <= maxN; j += i) {
                if (spf[(int) j] == 0) {
                    spf[(int) j] = i;
                }
            }
        }
    }
}


public static HashMap<Integer, Integer> factor(int n) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    
    while (n > 1) {
        int prime = spf[n]; // smallest prime factor
        hm.put(prime, hm.getOrDefault(prime, 0) + 1);
        n /= prime;
    }

    return hm;
}
    public static void main(String[] args) {
        sieve();
        System.out.println(factor(840));
    }
}
