import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
	// length of input arrays
        int len1 = a.length, len2 = b.length;

	// state table
	int[][] l = new int [len1][len2];
        
        // loop indices
        int i, j;

	// intialization - first column
	for (i = 0 ; i < len1 ; i++)	{
            if (a[i] != b[0])
                l[i][0] = 0;
            else
                // rest all will be ones
                break;
	}

	while (i < len1)
            l[i++][0] = 1;

	// intialization - first row
	for (j = 0 ; j < len2 ; j++)	{
            if (b[j] != a[0])
                l[0][j] = 0;
            else
                // rest all will be ones
                break;
	}

	while (j < len2)
            l[0][j++] = 1;	

	// induction step
	for (i = 1 ; i < len1 ; i++)	{
            for (j = 1 ; j < len2 ; j++)	{
                if (a[i] == b[j])	{
                    l[i][j] = 1 + l[i - 1][j -1];
                }
                else	{
                    if (l[i - 1][j] <= l[i][j - 1])
                        l[i][j] = l[i][j - 1];
                    else
                        l[i][j] = l[i - 1][j];
                }
            }
	}
        return l[len1 - 1][len2 - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

