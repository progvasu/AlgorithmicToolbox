import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        // Step1. Find Period - The sequence will repeat
	int period_max = (6 * (int)m + 2), period = 1;
	long[] periodArray = new long[period_max];
        
	periodArray[0] = 0;
	periodArray[1] = 1;

	for(int i = 2 ; i < period_max ; i++)	{
            periodArray[i] = (periodArray[i - 1] + periodArray[i - 2]) % m;
            // System.out.println(periodArray[i]);
            if (periodArray[i - 1] == 0 && periodArray[i] == 1)	{
                period = i - 1;
                break;
            }
	}
        
	// Step2. Find the mod of n
	int mod_result = (int)(n % period);

        return periodArray[mod_result];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}

