public class Modular_Exponentiation {
     public static long modPow(long a, long n, long mod) {
        long res = 1;
        a = a % mod;

        while (n > 0) {
            if ((n & 1) == 1) {
                res = (res * a) % mod;
            }
            a = (a * a) % mod;
            n >>= 1;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(modPow(2, 24, 1_000_000_007)); 
        System.out.println(modPow(3, 100, 1_000_000_007)); 
    }
}
