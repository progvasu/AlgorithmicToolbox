import java.util.*;

public class Inversions {
    private static long merge(int[] input_array, int min, int mid, int max)   {
        long count = 0;
	int i = min, j = mid + 1, k = 0;
	int[] temp = new int[max - min + 1];

	while (i <= mid && j <= max)	{
		if (input_array[i] <= input_array[j])	{
			temp[k++] = input_array[i++];
		}
		else if (input_array[i] > input_array[j])	{
			temp[k++] = input_array[j++];
			count = count + (mid - i + 1);
		}
	}

	// are elements remaining in min - mid
	while(i <= mid)	{
		temp[k++] = input_array[i++];
	}

	while(j <= max)	{
		temp[k++] = input_array[j++];
	}

	// copying array back to original array
	for (i = 0 ; i < k ; i++)	{
		input_array[min++] = temp[i];
	}

	return count;
    }
    
    private static long getNumberOfInversions(int[] a, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int ave = (left + right) / 2;
        long leftc = getNumberOfInversions(a, left, ave);
        long rightc = getNumberOfInversions(a, ave + 1, right);
        //write your code here
        long merge = merge(a, left, ave, right);
        
        return leftc + rightc + merge;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, 0, a.length - 1));
    }
}

