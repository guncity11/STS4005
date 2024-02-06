// YT : https://www.youtube.com/watch?v=cHrH9CQ8pmY
// Basically a "leader" is an element that is greater than all the elements to its right side in the array.

import java.util.Scanner;

public class LeadersinArray {
public static void main(String[] args) {
    
    //take array as input
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }

    //actual algo starts
    for (int i = 0; i < arr.length; i++)
        {
        int j;
            for (j = i + 1; j < arr.length; j++)
                {
                    if (arr[i] <= arr[j])
                    break;
                }
        if (j == arr.length)
        System.out.print(arr[i] + " ");
        }
    sc.close();
    }
}