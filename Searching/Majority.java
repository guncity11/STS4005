// YT : https://www.youtube.com/watch?v=nP_ns3uSh80
// element that appears more than n/2 times in an array.

import java.util.Scanner;

public class Majority {

    //main algo
    static int findMajorityElement(int[] arr) {
        int count = 0, candidate = 0;
        for (int num : arr) {
            if (count == 0) candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
    public static void main(String[] args) {

        //array as input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.println(findMajorityElement(arr));

        sc.close();
    }
}
