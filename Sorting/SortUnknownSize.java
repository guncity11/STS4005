import java.util.*;

public class SortUnknownSize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();

        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        Integer[] arr = list.toArray(new Integer[0]);
        Arrays.sort(arr);

        for (int i : arr) {
            System.out.println(i + " ");   
        }

        System.out.println(arr[(arr.length - 1)]);

        sc.close();
    }
}
