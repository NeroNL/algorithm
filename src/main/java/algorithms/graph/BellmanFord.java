package algorithms.graph;

import java.util.Arrays;

public class BellmanFord {

    class Node {
        int from, cost, to;
        public Node (int from, int to, int cost) {
            this.from = from;
            this.cost = cost;
            this.to = to;
        }
    }

    /**
     * Find out the shortest distance for every edge.
     * If there is a negative cycle, then we should set the distance to negative infinity.
     * @param edges a edge that includes the nodes it connects and the cost
     * @param V the total number of node
     * @param start the start node
     * @return
     */
    public static double[] bellmanFord(Node[] edges, int V, int start) {
        double[] dist = new double[V];
        Arrays.fill(dist, Double.POSITIVE_INFINITY);
        dist[start] = 0;

        // Only in the worst case does it take V-1 iterations for the Bellman-Ford
        // algorithm to complete. Another stopping condition is when we're unable to
        // relax an edge, this means we have reached the optimal solution early.
        boolean relax = true;

        for (int i = 0; i < V-1 && relax; ++i) {
            relax = false;
            for (Node edge : edges) {
                if (dist[edge.from] + edge.cost < dist[edge.to]) {
                    dist[edge.to] = dist[edge.from] + edge.cost;
                    relax = true;
                }
            }
        }

        relax = true;
        for (int i = 0; i < V-1 && relax; ++i) {
            relax = false;
            for (Node edge : edges) {
                if (dist[edge.from] + edge.cost < dist[edge.to]) {
                    dist[edge.to] = Double.NEGATIVE_INFINITY;
                    relax = true;
                }
            }
        }

        return dist;
    }
}
