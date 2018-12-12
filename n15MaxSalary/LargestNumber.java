import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        String result = "";
        
        Arrays.sort(a, new StringComp());
        
        for (String str : a)
            result = result + str;
        
        return result;
    }
    
    static class StringComp implements Comparator<String>     {
        @Override
        public int compare(String s1, String s2) {
            int i = 0;
            for (i = 0 ; i < s1.length() && i < s2.length() ; i++)  {
                if (s1.charAt(i) <  s2.charAt(i))
                    return 1;
                else if (s1.charAt(i) > s2.charAt(i))
                    return -1;
                else    {
                    // do nothing
                }
            }
            
            if (s1.length() == s2.length())
                // strings were equal
                return 0;
            
            // else compare the longer string with the first element of
            // shorter string
            if (s1.length() < s2.length())   {
                for (int j = 0 ; j < s1.length() ; j++) {
                    if (s1.charAt(j) < s2.charAt(i))
                        return 1;
                    else if (s1.charAt(j) > s2.charAt(i))
                        return -1;
                        
                }
//                for (; i < s2.length() ; i++) {
//                    if (s1.charAt(0) < s2.charAt(i))
//                        return 1;
//                    else if (s1.charAt(0) > s2.charAt(i))
//                        return -1;
//                    else {
//                        // if equal then compared with the next character of smaller input
//                        
//                    }
//                }
            }
            else {
//                for (; i < s1.length() ; i++) {
//                    if (s2.charAt(0) > s1.charAt(i))
//                        return 1;
//                    else if (s2.charAt(0) < s1.charAt(i))
//                        return -1;
//                }
                for (int j = 0 ; j < s2.length() ; j++) {
                    if (s1.charAt(i) < s2.charAt(j))
                        return 1;
                    else if (s1.charAt(i) > s2.charAt(j))
                        return -1;
                        
                }
            }
            
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

