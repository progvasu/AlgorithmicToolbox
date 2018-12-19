import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        // loop invariantes	
	int i, j;

	// knapsack problem statement	
	int items = w.length, knap_size = W;

	int total_weight = W;
	
	// state table - v[i][j] = maximum profit we can make by using first 'i' items and a knapsack of size 'j'
	int[][] V = new int[items][W + 1];

	// initialization
	// first row
	for (j = 1 ; j <= total_weight ; j++)	{
            if (w[0] > j)
                V[0][j] = 0;
            else
                V[0][j] = w[0];
	}

	// first column - zero value for knapsack of size 0
	for (i = 0 ; i < items ; i++)
		V[i][0] = 0;

	// induction
	for (i = 1 ; i < items ; i++)	{
            for (j = 1 ; j <= total_weight ; j++)	{
                if (j >= w[i] && ((w[i] + V[i - 1][j - w[i]]) > V[i - 1][j]))
                    V[i][j] = w[i] + V[i - 1][j - w[i]];
                else
                    V[i][j] = V[i - 1][j];
            }
	}
        
        int result = V[items - 1][W];
	
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

