import java.lang.Math;
public class Main {
    public static void main(String[] args) {
int i = 7;
    while (i < 10) {
        tid((long) Math.pow(10, i));
        i++; 
    }    
    }
    public static void tid(long n) {
        long startTime = System.currentTimeMillis();  
        long k = 0;
        for (long i = 1; i <= n; i++) {
            k = k + 5;
        }
        long endTime = System.currentTimeMillis(); 
        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");
    }
}