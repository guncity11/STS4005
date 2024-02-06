public class HamCycle {
    final int V;
    int path[];

    public HamCycle(int V) {
        this.V = V;
        this.path = new int[V];

        for (int i = 0; i < V; i++)
            this.path[i] = -1;
    }

    boolean isSafe(int v, int graph[][], int path[], int pos) {
        if (graph[path[pos - 1]][v] == 0)
            return false;

        for (int i = 0; i < pos; i++)
            if (path[i] == v)
                return false;

        return true;
    }

    boolean hamCycleUtil(int graph[][], int path[], int pos) {
        if (pos == V) {
            return graph[path[pos - 1]][path[0]] == 1;
        }

        for (int v = 1; v < V; v++) {
            if (isSafe(v, graph, path, pos)) {
                path[pos] = v;

                if (hamCycleUtil(graph, path, pos + 1))
                    return true;

                path[pos] = -1; // Backtrack
            }
        }
        return false;
    }

    int[] hamCycle(int graph[][]) {
        path[0] = 0;
        if (!hamCycleUtil(graph, path, 1)) {
            System.out.println("Solution does not exist");
            return null;
        }

        return path;
    }
}
