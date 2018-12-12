import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        // sort segments according to their end time - increasing order
        Arrays.sort(segments);
        
        List<Integer> points = new ArrayList<>();
        
        int point = segments[0].end;
        points.add(point);
        
        for (int i = 1 ; i < segments.length ; i++)   {
            // does point lies within the segment
            if (point < segments[i].start || point > segments[i].end)   {
                // need a new point
                point = segments[i].end;
                points.add(point);
            }
        }
        
        // convert array list to int array and return
        int[] result = new int[points.size()];
        for (int i = 0 ; i < result.length ; i++)   
            result[i] = points.get(i);
            
        return result;
    }

    private static class Segment implements Comparable<Segment>{
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Segment o) {
            return this.end - o.end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
