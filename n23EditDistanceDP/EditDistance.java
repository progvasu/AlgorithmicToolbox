import java.util.*;

class EditDistance {
    public static int EditDistance(String s, String t) {
        // state table
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        
        // loop indices
        int i, j;
        
        // initialization
        // first row
        for (j = 0 ; j <= t.length() ; j++)
            dp[0][j] = j;
        // first column
        for (i = 0 ; i <= s.length() ; i++)
            dp[i][0] = i;
        
        // induction
        for (i = 1 ; i <= s.length() ; i++) {
            for (j = 1 ; j <= t.length() ; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i - 1][j - 1]));
                }
                else    {
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }
        
        return dp[s.length()][t.length()];
    }
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(EditDistance(s, t));
    }
}
