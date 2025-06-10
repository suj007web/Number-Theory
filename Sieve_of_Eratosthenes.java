
public class Sieve_of_Eratosthenes {
    //  o(nloglogn) + o(n)
    static int is_prime[] = new int[1_000_001];
    public static void precompute(){
        int max = 1_000_000;

        for(int i = 1; i <= max; i++) is_prime[i] = 1;
        is_prime[0] = is_prime[1] = 0;

        for(int i = 2; i*i <= max; i++){
            if(is_prime[i] == 1){
                for(int j = i * i; j <= max; j += i){
                    is_prime[j] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        precompute();
        System.out.println(is_prime[7]);
    }    
}
