// import java.util.Arrays;
// import java.util.Scanner;
import java.util.*;
public class Sort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);

        for (int i : arr) {
            System.out.println(i + " ");   
        }

        System.out.println(arr[(arr.length - 1)]);

        sc.close();
    }
}