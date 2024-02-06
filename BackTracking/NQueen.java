import java.util.Scanner;

public class NQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the board (N): ");
        int n = scanner.nextInt(); // User inputs the size of the board
        scanner.close();

        if (n <= 0) {
            System.out.println("The size of the board must be a positive integer.");
            return;
        }

        placeQueens(n);
    }

    public static void placeQueens(int n) {
        int[] board = new int[n]; // Each index represents row, value represents column
        if (!solveNQueens(board, 0)) {
            System.out.println("No solution found.");
        }
    }

    private static boolean solveNQueens(int[] board, int row) {
        if (row == board.length) {
            printSolution(board);
            return true;
        }

        boolean result = false;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row] = col;
                result = solveNQueens(board, row + 1) || result; // try next row
            }
        }
        return result;
    }

    private static boolean isSafe(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(row - i) == Math.abs(col - board[i])) {
                return false;
            }
        }
        return true;
    }

    private static void printSolution(int[] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                System.out.print(board[row] == col ? "Q " : "_ ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
