import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;
        
        // define fibo array
        int[] fibo = new int[n + 1];
        
        fibo[0] = 0;
        fibo[1] = 1;
        
        for (int i = 2 ; i <= n ; i++)
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 10;
        
        return fibo[n];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}

