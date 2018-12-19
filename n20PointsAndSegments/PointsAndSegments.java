import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PointsAndSegments {
    static class Points implements Comparable<Points>{
        int number;
        char id;
        
        Points(int number, char id) {
            this.number = number;
            this.id = id;
        }

        @Override
        public int compareTo(Points o) {
            if (this.number < o.number)
                return -1;
            else if (this.number == o.number)   {
                if (this.id < o.id)
                    return -1;
                else if (this.id > o.id)
                    return 1;
                else 
                    return 0;
            }
            else 
                return 1;
        }
    }
    
    private static long[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        long[] cnt = new long[points.length];
        
        // lets create a hash map of points with 'cnt' so that we can match them at the end
        Map<Integer, Long> myMap = new HashMap<>();
        for(int i = 0 ; i < points.length ; i++)  {
            myMap.put(points[i], cnt[i]);
        }
        
        // Points array
        List<Points> points_array = new ArrayList<>(starts.length * 2 + points.length);
        
        // creating a new object for every point in starts, ends and points
        for (int i = 0 ; i < starts.length ; i++)   {
            points_array.add(new Points(starts[i], 'l'));
            points_array.add(new Points(ends[i], 'r'));
        }
        for (int i = 0 ; i < points.length ; i++)   {
            points_array.add(new Points(points[i], 'p'));
        }
        
        // sorting points_array
        Collections.sort(points_array);
        
        // counting for all points
        long run_count_seg = 0;
        Points temp_point;
        for (int i = 0 ; i < points_array.size() ; i++) {
            temp_point = points_array.get(i);
            
            if (temp_point.id == 'l')
                run_count_seg++;
            else if (temp_point.id == 'r')
                run_count_seg--;
            else    {
                myMap.put(temp_point.number, run_count_seg);
            }
        }
        
        // getting values out of the hash
        for(int i = 0 ; i < cnt.length ; i++)   {
            cnt[i] = myMap.get(points[i]);
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
        // use fastCountSegments
        long[] cnt = fastCountSegments(starts, ends, points);
        for (long x : cnt) {
            System.out.print(x + " ");
        }
    }
}