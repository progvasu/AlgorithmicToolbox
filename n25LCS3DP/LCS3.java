import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        // length of input arrays
        int len1 = a.length, len2 = b.length, len3 = c.length;

	// state table
	int[][][] l = new int [len1 + 1][len2 + 1][len3 + 1];
        
        // loop indices
        int i, j, k;

//	// intialization - first column
//	for (i = 0 ; i < len1 ; i++)	{
//            if (a[i] != b[0] && a[i] != c[0])
//                l[i][0][0] = 0;
//            else
//                // rest all will be ones
//                break;
//	}
//
//	while (i < len1)
//            l[i++][0][0] = 1;
//
//	// intialization - first row
//	for (j = 0 ; j < len2 ; j++)	{
//            if (b[j] != a[0] && b[j] != c[0])
//                l[0][j][0] = 0;
//            else
//                // rest all will be ones
//                break;
//	}
//
//	while (j < len2)
//            l[0][j++][0] = 1;	
//
//        // intialization - first depth - k axis
//	for (k = 0 ; k < len3 ; k++)	{
//            if (c[k] != a[0] && c[k] != b[0])
//                l[0][0][k] = 0;
//            else
//                // rest all will be ones
//                break;
//	}
//
//	while (k < len3)
//            l[0][0][k++] = 1;
        
        // above initializations will not work
        // if any of the strings are zero LCS is zero
        
	// induction step
	for (i = 0 ; i <= len1 ; i++)	{
            for (j = 0 ; j <= len2 ; j++)	{
                for (k = 0 ; k <= len3 ; k++)    {
                    if (i == 0 || j == 0 || k == 0)
                        l[i][j][k] = 0;
                    else if (a[i - 1] == b[j - 1] && b[j - 1] == c[k - 1])	{
                        l[i][j][k] = 1 + l[i - 1][j - 1][k - 1];
                    }
                    else	{
                        // for single character removed
                        l[i][j][k] = Math.max(l[i - 1][j][k], Math.max(l[i][j - 1][k], l[i][j][k - 1]));
                    }
                }
            }
	}
        return l[len1][len2][len3];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

