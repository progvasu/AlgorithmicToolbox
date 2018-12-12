import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        from -= 1;
        
        // Modification of n7 
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
        int mod_result1 = (int)(from % period);
	int mod_result2 = (int)(to % period);
        
        int sum1 = 0;
        // Step3. Loop from 0 to mod_result
        for (int i = 0 ; i <= mod_result1 ; i++)
            sum1 = (sum1 + (int)periodArray[i]) % 10;
        
        int sum2 = 0;
        // Step3. Loop from 0 to mod_result
        for (int i = 0 ; i <= mod_result2 ; i++)
            sum2 = (sum2 + (int)periodArray[i]) % 10;
        
        if (sum2 <= sum1)
            sum2 += 10;
        
        return (sum2 - sum1) % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}

