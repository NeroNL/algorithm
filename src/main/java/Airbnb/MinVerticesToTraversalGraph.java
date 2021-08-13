package Airbnb;

import java.util.*;

public class MinVerticesToTraversalGraph {

    Set<Integer> res;
    boolean[] visited;

    private void search(Map<Integer, Set<Integer>> map, Set<Integer> curVisited, int node, int start) {
        visited[node] = true;
        curVisited.add(node);
        for (Integer next : map.get(node)) {
            if (res.contains(next) && next != start) res.remove(next);
            if (curVisited.contains(next)) continue;
            search(map, curVisited, next, start);
        }
    }

    public List<Integer> solve(int[][] edges, int n) {
        res = new HashSet<>();
        visited = new boolean[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(i, new HashSet<>());
        }
        for (int[]e : edges) {
            map.get(e[0]).add(e[1]);
        }

        for (int i = 0; i < n; ++i) {
            if (visited[i]) continue;
            res.add(i);
            search(map, new HashSet<>(), i, i);
        }

        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1}, {1,0}, {3,1}, {3,2},{2,1}};
        MinVerticesToTraversalGraph s = new MinVerticesToTraversalGraph();
        //for (Integer num : s.solve(edges, 4)) System.out.println(num);
        s.solve(edges, 4).forEach(System.out::println);
    }
}
