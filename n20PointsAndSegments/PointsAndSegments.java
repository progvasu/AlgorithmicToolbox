import java.util.Arrays;
import java.util.Scanner;

public class PointsAndSegments {
    private static int binarySearchSmaller(int[] a, int x) {
        int left = 0, right = a.length - 1, mid = -1;
        
        while (left <= right)   {
            mid = (left + right) / 2;
            
            if (a[mid] == x)
                return mid + 1;
            
            if (a[mid] < x)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }
    
    private static int binarySearchBigger(int[] a, int x) {
        int left = 0, right = a.length - 1, mid = -1;
        
        while (left <= right)   {
            mid = (left + right) / 2;
            
            if (a[mid] == x)
                return a.length - mid;
            
            if (a[mid] < x)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return a.length - left;
    }
    
    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        
        // need to sort the start array
        // then sort the end array
        // then use binary search to find all s <= x
        // and all l >= x
        // then ans = s + l - n(starts.length())
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int s, l, n = starts.length;
                
        // apply binary search for each point
        for (int i = 0 ; i < points.length ; i++)   {
            s = binarySearchSmaller(starts, points[i]);
            l = binarySearchBigger(ends, points[i]);
            
            cnt[i] = s + l - n;
        }
        
        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

