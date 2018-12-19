import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
        int n = (exp.length() + 1) / 2;
        
        // dp tables
        long[][] min = new long[n + 1][n + 1];
        long[][] max = new long[n + 1][n + 1];
        
        for (int i = 1 ; i <= n ; i++)  {
            min[i][i] = (int) exp.charAt(2 * (i - 1)) - '0';
            max[i][i] = (int) exp.charAt(2 * (i - 1)) - '0';
        }
        
        int j;
        long temp_min, temp_max;
        long a, b, c, d;
        for (int s = 1 ; s <= n - 1 ; s++)    {
            for (int i = 1 ; i <= n - s ; i++)  {
                j = i + s;
                temp_min = Long.MAX_VALUE;
                temp_max = Long.MIN_VALUE;
                for (int k = i ; k <= j - 1 ; k++)  {
                    a = eval(max[i][k], max[k + 1][j], exp.charAt(2 * (k - 1) + 1));
                    b = eval(max[i][k], min[k + 1][j], exp.charAt(2 * (k - 1) + 1));
                    c = eval(min[i][k], max[k + 1][j], exp.charAt(2 * (k - 1) + 1));
                    d = eval(min[i][k], min[k + 1][j], exp.charAt(2 * (k - 1) + 1));
                    temp_min = Math.min(temp_min, a);
                    temp_min = Math.min(temp_min, b);
                    temp_min = Math.min(temp_min, c);
                    temp_min = Math.min(temp_min, d);
                    temp_max = Math.max(temp_max, a);
                    temp_max = Math.max(temp_max, b);
                    temp_max = Math.max(temp_max, c);
                    temp_max = Math.max(temp_max, d);
                }
                min[i][j] = temp_min;
                max[i][j] = temp_max;
            }
        }
        
        return max[1][n];
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

