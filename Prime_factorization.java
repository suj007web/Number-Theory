import java.util.*;

public class Prime_factorization {
    //if N is composite number then there is at least 1 prime divisor of N below sqrt(n)
    // TC = O(sqrt n)
    public static HashMap<Integer, Integer> prime_factor(int n ){
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 2; i*i <= n; i++ ){
            if(n%i==0){
                int cnt = 0;
                while(n%i == 0){
                    cnt++;
                    n/=i;
                    hm.put(i, hm.getOrDefault(i, 0) + 1);
                }
            }
        }
        if(n>1){
            hm.put(n, hm.getOrDefault(n, 0)+1);
        }

        return hm;
    }
    public static void main(String[] args) {
        System.out.println(prime_factor(12));
    }
}
