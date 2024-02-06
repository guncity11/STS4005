class JosephusTrap {
    static int josephus(int n, int k) {
        if (n == 1)
            return 1; // Base case: if only one person remains
        else
            // The recursive formula to find the position of the last person standing
            return (josephus(n - 1, k) + k - 1) % n + 1;
    }

    public static void main(String[] args) {
        int n = 5; // Number of people
        int k = 2; // Count to determine which person is executed
        System.out.println("The chosen place is " + josephus(n, k)); // Sample Value
    }
}