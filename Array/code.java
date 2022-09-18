import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class code {
    // PRINT ARRAY
    public static void printArray(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    // BINARY SEARCH
    public static int binarySearch(int[] input, int n) {
        int start = 0;
        int end = input.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (n == input[mid]) {
                return mid;
            } else if (input[mid] > n) {
                end = mid - 1;
            } else if (input[mid] < n) {
                start = mid + 1;
            }
        }
        return -1;
    }

    // SELECTION SORT
    public static void selectionSort(int[] input) {

        for (int i = 0; i < input.length - 1; i++) {
            int min = input[i];
            int minIndex = i;
            for (int j = i + 1; j < input.length; j++) {
                // Getting the Minimum number from the range of array
                if (input[j] < min) {
                    min = input[j];
                    minIndex = j;
                }
            }
            // if the smallest element is not same then...
            if (i != minIndex) {
                input[minIndex] = input[i];
                input[i] = min;
            }
        }
    }

    // BUBBLE SORT
    public static void bubbleSort(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] > input[j + 1]) {
                    int temp = input[j + 1];
                    input[j + 1] = input[j];
                    input[j] = temp;
                }
            }
        }

    }

    // INSERTION SORT
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int currentElement = arr[i];
            while (j >= 0 && currentElement < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = currentElement;
        }
    }

    // MERGE TWO SORTED ARRAYS
    public static int[] merge(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int k = 0;

        int[] ans = new int[arr1.length + arr2.length];
        while (i < arr1.length && j < arr2.length) {
            if (arr2[j] > arr1[i]) {
                ans[k] = arr1[i];
                k++;
                i++;
            } else {
                ans[k] = arr2[j];
                j++;
                k++;
            }
        }
        while (i < arr1.length) {
            ans[k] = arr1[i];
            i++;
            k++;
        }
        while (j < arr2.length) {
            ans[k] = arr2[j];
            j++;
            k++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (System.getProperty("ONLINE_JUDGE") == null) {
            try {
                System.setOut(new PrintStream(new FileOutputStream("output.txt")));
                sc = new Scanner(new File("input.txt"));
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }

        // Your Code Starts Here
        int[] input1 = { 1, 2, 6 };
        int[] input2 = { 3, 4, 5, 9 };
        int[] ans = merge(input1, input2);
        printArray(ans);
        sc.close();
    }
}
