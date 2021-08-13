package algorithms.graph;

import java.util.List;

import static java.lang.Math.min;

public class FordFulkerson extends NetworkFlowSolverBase {

    /**
     * Creates an instance of a flow network solver. Use the {@link #addEdge} method to add edges to
     * the graph.
     *
     * @param n - The number of nodes in the graph including source and sink nodes.
     * @param s - The index of the source node, 0 <= s < n
     * @param t - The index of the sink node, 0 <= t < n, t != s
     */
    public FordFulkerson(int n, int s, int t) {
        super(n, s, t);
    }

    @Override
    public void solve() {

        // Find max flow by adding all augmenting path flows.
        for (long f = dfs(s, INF); f != 0; f = dfs(s, INF)) {
            markAllNodesAsUnvisited();
            maxFlow += f;
        }

        // Find min cut.
        for (int i = 0; i < n; i++) if (visited(i)) minCut[i] = true;
    }

    private long dfs(int node, long flow) {
        // At sink node, return augmented path flow.
        if (node == t) return flow;

        List<Edge> edges = graph[node];
        visit(node);

        for (Edge edge : edges) {
            long rcap = edge.remainingCapacity();
            if (rcap > 0 && !visited(edge.to)) {
                long bottleNeck = dfs(edge.to, min(flow, rcap));

                // Augment flow with bottle neck value
                if (bottleNeck > 0) {
                    edge.augment(bottleNeck);
                    return bottleNeck;
                }
            }
        }
        return 0;
    }

}
