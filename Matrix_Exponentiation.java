public class Matrix_Exponentiation {
    // Time Complexity = O(N^3 * log n)
    static int N = 3;
    static int[][] I = new int[N][N];

    // Matrix multiplication: i = i * a
    static void mul(int[][] i, int[][] a, int dim) {
        int[][] res = new int[dim][dim];

        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                for (int k = 0; k < dim; k++) {
                    res[row][col] += i[row][k] * a[k][col];
                }
            }
        }

        // Copy result back into matrix i
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                i[row][col] = res[row][col];
            }
        }
    }

    static void power(int[][] a, int dim, int n) {
        // init identity matrix
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (i == j) I[i][j] = 1;
                else I[i][j] = 0;
            }
        }

        while (n > 0) {
            if ((n & 1) == 1) {
                mul(I, a, dim); // I = I * a
            }
            mul(a, a, dim); // a = a * a
            n >>= 1;
        }

    
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                a[i][j] = I[i][j];
            }
        }
    }

    public static void main(String[] args) {
  
        int[][] mat = {
            {1, 0, 0},
            {0, 5, 0},
            {0, 0, 3}
        };

        int power = 3;

        power(mat, N, power);


        System.out.println("Matrix raised to power " + power + ":");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
