public class Binary_Exponentiation {
    // TC = O(log n )
public static int pow(int a, int n) {
    int res = 1;
    while (n > 0) {
        if ((n & 1) == 1) {
            res *= a;
        }
        a *= a;
        n >>= 1;
    }
    return res;
}

    public static void main(String[] args) {
        System.out.println(pow(2, 24));
    }
}
