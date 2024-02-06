// YT : https://www.youtube.com/watch?v=pOZUyPWelh4
// Finding equilibrium point where elements before & after it has equal sum

import java.util.Scanner;

public class MaxEquilibrium {

    //Actual Algo
    static int maxEquilibriumSum(int[] arr) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;
        int leftSum = 0, maxEqSum = Integer.MIN_VALUE;
        for (int num : arr) {
            if (leftSum == totalSum - leftSum - num) maxEqSum = Math.max(maxEqSum, leftSum + num + leftSum);
            leftSum += num;
        }
        return maxEqSum == Integer.MIN_VALUE ? 0 : maxEqSum;
    }

    public static void main(String[] args) {

        //array as input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        //print eq point
        System.out.println(maxEquilibriumSum(arr));
        sc.close();
    }
}
