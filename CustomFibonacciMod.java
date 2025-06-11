public class CustomFibonacciMod {

    static final long MOD = 1_000_000_007;

    static void multiply(long[][] a, long[][] b) {
        long[][] res = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }

        // Copy back to a
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] = res[i][j];
            }
        }
    }

    static void power(long[][] a, long n) {
        long[][] res = {
            {1, 0},
            {0, 1}
        };

        while (n > 0) {
            if ((n & 1) == 1) {
                multiply(res, a);
            }
            multiply(a, a);
            n >>= 1;
        }

        // Copy result back
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] = res[i][j];
            }
        }
    }

    static long fib(long A, long B, long n) {
        if (n == 0) return A % MOD;
        if (n == 1) return B % MOD;

        long[][] T = {
            {0, 1},
            {1, 1}
        };

        power(T, n - 1);

        // F(n) = T[1][0] * A + T[1][1] * B
        return (T[1][0] * A % MOD + T[1][1] * B % MOD) % MOD;
    }

    public static void main(String[] args) {
        long A = 2;
        long B = 3;
        long n = 1_000_000_000_000L;

        System.out.println("F(" + n + ") = " + fib(A, B, n));
    }
}
