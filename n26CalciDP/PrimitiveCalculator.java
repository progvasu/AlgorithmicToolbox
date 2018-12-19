import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        // backtracking
        List<Integer> sequence = new ArrayList<Integer>();
        
        // state table
        int[] dp = new int[n + 1];
        
        // initialization
        dp[1] = 0;
        
        int min_opr;
        
        // induction
        for (int i = 2 ; i <= n ; i++)  {
            // from addition
            min_opr = dp[i - 1] + 1;
            
            // from divide by 2
            if (i % 2 == 0) {
                min_opr = Math.min(min_opr, dp[i / 2] + 1);
            }
            
            // from divide by 2
            if (i % 3 == 0) {
                min_opr = Math.min(min_opr, dp[i / 3] + 1);
            }
            
            dp[i] = min_opr;
        }
        
        // backtrack for sequence
        while (n >= 1)  {
            sequence.add(n);
            if (n == 1)
                break;
                      
            if (dp[n] == dp[n - 1] + 1) {
                n = n - 1;
            }
            else if (n % 2 == 0 && dp[n] == dp[n / 2] + 1)
                n = n / 2;
            else if (n % 3 == 0 && dp[n] == dp[n / 3] + 1)
                n = n / 3;
        }
        
        Collections.reverse(sequence);
                
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

