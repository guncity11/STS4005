// YT : https://youtu.be/YK78FU5Ffjw?t=145
//  Print all Permutations of a array

import java.util.*;

public class UniqPerm {

    //main algo
    static void permuteUnique(int[] arr, int start, List<List<Integer>> result) {
        if (start == arr.length) {
            List<Integer> current = new ArrayList<>();
            for (int num : arr) current.add(num);
            result.add(new ArrayList<>(current));
            return;
        }
        HashSet<Integer> appeared = new HashSet<>();
        for (int i = start; i < arr.length; i++) {
            if (appeared.add(arr[i])) {
                swap(arr, start, i);
                permuteUnique(arr, start + 1, result);
                swap(arr, start, i); // backtrack
            }
        }
    }

    //swapping numbers
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {

        //array as input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        permuteUnique(arr, 0, result);
        System.out.println(result);
        sc.close();
    }
}
