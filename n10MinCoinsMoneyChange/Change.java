import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        if (m < 5)
            return m;
        
        if (m < 10)
            return 1 + (m - 5);
        
        return 1 + getChange(m - 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

