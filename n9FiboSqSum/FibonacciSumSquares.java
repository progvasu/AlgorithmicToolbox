import java.util.*;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        // Step1. Find Period - The sequence will repeat
	int period_max = (6 * 10 + 2), period = 1;
	long[] periodArray = new long[period_max];
        
	periodArray[0] = 0;
	periodArray[1] = 1;

	for(int i = 2 ; i <= period_max ; i++)	{
            periodArray[i] = (periodArray[i - 1] + periodArray[i - 2]) % 10;
            // System.out.println(periodArray[i]);
            if (periodArray[i - 1] == 0 && periodArray[i] == 1)	{
                period = i - 1;
                break;
            }
	}
        
	// Step2. Find the mod of n
	int mod_result1 = (int)(n % period);
        int mod_result2 = (int)((n - 1) % period);
        
        return (periodArray[mod_result1] * (periodArray[mod_result2] + periodArray[mod_result1])) % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresNaive(n);
        System.out.println(s);
    }
}

