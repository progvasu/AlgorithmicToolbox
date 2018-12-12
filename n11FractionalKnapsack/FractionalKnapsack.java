import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        
        // need to find the value/weight combination and pick them up one by one
        double[] frac = new double[values.length];
        for (int i  = 0 ; i < frac.length ; i++)  {
            frac[i] = (double)values[i] / weights[i];
        }
        
        // sorting frac in desc and also weights array based on frac
        // Mapping a frac value to the weight value
        Map<Double, Double> myMap = new HashMap<>();
        for(int i = 0 ; i < frac.length ; i++)  {
            myMap.put(frac[i], Double.valueOf(weights[i]));
        }
        
        Arrays.sort(frac);
        
        // rearrange weights
        for(int i = 0 ; i < weights.length ; i++)   {
            weights[i] = myMap.get(frac[i]).intValue();
        }
            
        int curr_item_wt = 0;
        // trying to pick all items and reducing capacity
        for (int i = weights.length - 1 ; i >= 0 ; i--)  {
            if (capacity == 0)
                return value;
            
            curr_item_wt = Math.min(weights[i], capacity);
            value = value + curr_item_wt * frac[i];
            
            capacity = capacity - curr_item_wt;
        }
        

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
