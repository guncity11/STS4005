import java.util.Scanner;

public class MazeRunner {
    private static final int PATH = 0, WALL = 1, VISITED = 2;
    private static final int[] rowMove = {0, 1, 0, -1}; // move directions (right, down, left, up)
    private static final int[] colMove = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Assuming a 5x5 maze for simplicity, 1 represents walls and 0 represents paths
        int[][] maze = {
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0},
            {0, 1, 1, 1, 0}
        };

        System.out.print("Enter the starting X coordinate: ");
        int startX = scanner.nextInt();
        System.out.print("Enter the starting Y coordinate: ");
        int startY = scanner.nextInt();
        System.out.print("Enter the destination X coordinate: ");
        int destX = scanner.nextInt();
        System.out.print("Enter the destination Y coordinate: ");
        int destY = scanner.nextInt();

        if (solveMaze(maze, startX, startY, destX, destY)) {
            System.out.println("Path found:");
            printMaze(maze);
        } else {
            System.out.println("No path found.");
        }

        scanner.close();
    }

    public static boolean solveMaze(int[][] maze, int x, int y, int destX, int destY) {
        if (x == destX && y == destY) {
            maze[x][y] = VISITED;
            return true;
        }

        if (isSafe(maze, x, y)) {
            maze[x][y] = VISITED;
            for (int i = 0; i < 4; i++) {
                int nextX = x + rowMove[i];
                int nextY = y + colMove[i];
                if (solveMaze(maze, nextX, nextY, destX, destY)) {
                    return true;
                }
            }
            maze[x][y] = PATH; // backtrack
        }
        return false;
    }

    private static boolean isSafe(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] != WALL && maze[x][y] != VISITED;
    }

    private static void printMaze(int[][] maze) {
        for (int[] row : maze) {
            for (int cell : row) {
                System.out.print(cell == VISITED ? "P " : cell == WALL ? "W " : "_ ");
            }
            System.out.println();
        }
    }
}
