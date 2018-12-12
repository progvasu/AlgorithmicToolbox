package n4GCD;

import java.util.*;

public class GCD {
    private static int gcd_naive(int a, int b) {
        // a is always bigger
        if (a < b)  {
            int temp;
            temp = a;
            a = b;
            b = temp;
        }

        // is b zero
        if (b == 0)
            return a;

        int remain = a % b;

        return gcd_naive(b, remain);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(gcd_naive(a, b));
    }
}
