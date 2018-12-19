import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        // coins
        int[] coins = new int[]{1, 3, 4};
                
        // state table
        int[] dp = new int[m + 1];
        
        // initialization
        dp[0] = 0;
        
        int num_coins;
        
        // induction
        for (int i = 1 ; i < dp.length ; i++)   {
            dp[i] = Integer.MAX_VALUE;
            for (int j  = 0 ; j < coins.length ; j++)   {
                if (i >= coins[j])   {
                    num_coins = dp[i - coins[j]] + 1;
                    if (num_coins < dp[i])
                        dp[i] = num_coins;
                }
            }
        }
       
        return dp[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

