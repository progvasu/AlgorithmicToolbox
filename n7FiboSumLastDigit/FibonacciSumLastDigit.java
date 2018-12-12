import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        // Same as n6 with m = 10
        // We just count the number of F1's for each iteration and find the 
        // Step1. Find Period - The sequence will repeat
	int period_max = (6 * (int)10 + 2), period = 1;
	long[] periodArray = new long[period_max];
        
	periodArray[0] = 0;
	periodArray[1] = 1;

	for(int i = 2 ; i < period_max ; i++)	{
            periodArray[i] = (periodArray[i - 1] + periodArray[i - 2]) % 10;
            // System.out.println(periodArray[i]);
            if (periodArray[i - 1] == 0 && periodArray[i] == 1)	{
                period = i - 1;
                break;
            }
	}
        
	// Step2. Find the mod of n
	int mod_result = (int)(n % period);
        
        int sum = 0;
        // Step3. Loop from 0 to mod_result
        for (int i = 0 ; i <= mod_result ; i++)
            sum = (sum + (int)periodArray[i]) % 10;
        
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}

