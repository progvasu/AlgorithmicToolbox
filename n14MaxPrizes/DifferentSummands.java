import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        
        // write your code here
        int p_alloc = 0;
        while (n > 0)  {
            p_alloc += 1;
            
            if (p_alloc <= n)   {
                summands.add(p_alloc);
            }
            else    {
                // add these remaining to previous one
                summands.set(summands.size() - 1, summands.get(summands.size() - 1) + n);
            }
            
            n -= p_alloc;
        }
        
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

