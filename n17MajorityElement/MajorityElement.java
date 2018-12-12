import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        // zero elements
        if (left > right) {
            return -1;
        }
        // one element
        if (left == right) {
            return a[left];
        }
        
        // write your code here
        int mid = (left + right) / 2;
        
        int leftR = getMajorityElement(a, left, mid);
        int rightR = getMajorityElement(a, mid + 1, right);
        
        // tester code
//        System.out.println("");
//        for (int i = left ; i <= mid  ; i++) {
//            System.out.print(a[i] + " ");
//        }
//        System.out.println("LeftR: " + leftR);
//        for (int i = mid + 1 ; i <= right  ; i++) {
//            System.out.print(a[i] + " ");
//        }
//        System.out.print("RightR: " + rightR);
//        System.out.println("");
        
        int count = 0;
        
        // no majority in any of them
        if (leftR == -1 && rightR == -1)
            return -1;
        // if common majority
        else if (leftR == rightR)
            return leftR;
        // check the one who returned the majority 
        // is that element the majority of the complete array
        // else if --- majortiy candidate from rightR
        else   {
            // assuming right one is the majority
            for (int i = left ; i <= right ; i++)
                if (a[i] == rightR)
                    count++;
            
            if (count > (right - left + 1) / 2)
                return rightR;
        
            count = 0;
            
            // if right one is not the majority then trying for left
            for (int i = left ; i <= right ; i++)
                if (a[i] == leftR)
                    count++;
            
            if (count > (right - left + 1) / 2)
                return leftR;
            else 
                return -1;
        }
        
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length - 1) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

