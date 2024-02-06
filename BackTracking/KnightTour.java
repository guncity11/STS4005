public class KnightTour {
    private static final int N = 8;
    private static final int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

    public static boolean solveKnightTour() {
        int[][] solution = new int[N][N];
        // Initialize solution matrix
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                solution[x][y] = -1;

        int x = 0, y = 0; // starting position
        solution[x][y] = 0; // First move is made

        if (!solveKTUtil(x, y, 1, solution)) {
            System.out.println("Solution does not exist");
            return false;
        } else {
            printSolution(solution);
            return true;
        }
    }

    // Utility method to solve the problem
    private static boolean solveKTUtil(int x, int y, int movei, int solution[][]) {
        int k, next_x, next_y;
        if (movei == N * N)
            return true;

        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, solution)) {
                solution[next_x][next_y] = movei;
                if (solveKTUtil(next_x, next_y, movei + 1, solution))
                    return true;
                else
                    solution[next_x][next_y] = -1; // Backtracking
            }
        }
        return false;
    }

    private static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    private static void printSolution(int sol[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + "\t");
            System.out.println();
        }
    }
}
