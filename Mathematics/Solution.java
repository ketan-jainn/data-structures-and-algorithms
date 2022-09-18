import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
// import java.math.*;

public class Solution {

    // Check if a number is Palindrome or not
    public static boolean isPalindrome(int n) {
        int temp = n;
        int reverse = 0;
        while (temp != 0) {
            int lastDigit = temp % 10;
            reverse = reverse * 10 + lastDigit;
            temp = temp / 10;
        }
        return (reverse == n);
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
        int n = sc.nextInt();
        System.out.println(isPalindrome(n));
        sc.close();
    }
}
