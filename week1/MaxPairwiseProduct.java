import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class MaxPairwiseProduct {
    static int getMaxPairwiseProduct(int[] numbers) {
        int max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                if (max_product > numbers[first] * numbers[second])
                    max_product = numbers[first] * numbers[second];
            }
        }

        return max_product;
    }

    static BigInteger getMaxPairwiseProductFast(int[] numbers) {
        int index1, index2, temp;
        int i;

        index1 = 0;
        for (i = 1 ; i < numbers.length ; i++)
            if (numbers[i] > numbers[index1])
                index1 = i;

        temp = numbers[index1];
        numbers[index1] = numbers[numbers.length - 1];
        numbers[numbers.length - 1] = temp;

        index2 = 0;
        for (i = 1 ; i < numbers.length - 1 ; i++)
            if (numbers[i] > numbers[index2])
                index2 = i;

        return (new BigInteger(String.valueOf(numbers[index2]))).multiply(BigInteger.valueOf(numbers[numbers.length - 1]));
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProductFast(numbers).toString());
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