class Maneuvering {
    static int numberOfPaths(int m, int n) {
        // Base case: if either m or n is 1, only one path is possible
        if (m == 1 || n == 1)
            return 1;
        // Recursive call to move right and down
        return numberOfPaths(m - 1, n) + numberOfPaths(m, n - 1);
    }

    public static void main(String args[]) {
        System.out.println(numberOfPaths(3, 3)); // Sample value
    }
}
