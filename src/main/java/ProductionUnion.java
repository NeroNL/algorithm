import java.util.*;

public class ProductionUnion {

    Map<Integer, Set<Integer>> graph = new HashMap<>();
    Set<Integer> availableNodes = new HashSet<>();

    private void connect (int key, int value) {
        Set<Integer> set = new HashSet<>();
        if (graph.containsKey(key)) {
            set = graph.get(key);
        }
        set.add(value);
        graph.put(key, set);
    }


    private void dfs(List<Integer> list, int curNode) {
        if (!availableNodes.contains(curNode)) return ;

        list.add(curNode);
        availableNodes.remove(curNode);

        if (graph.containsKey(curNode)) {
            for (Integer next : graph.get(curNode)) {
                dfs(list, next);
            }
        }
    }


    public List<List<Integer>> solve(int[][] matrix) {
        List<List<Integer>> ret = new ArrayList<>();

        if (matrix == null || matrix.length == 0) return ret;

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                connect(matrix[i][0], matrix[i][j]);
                connect(matrix[i][j], matrix[i][0]);
                availableNodes.add(matrix[i][j]);
            }
        }


        for (Integer curNode : graph.keySet()) {
            List<Integer> list = new ArrayList<>();
            dfs(list, curNode);
            if (!list.isEmpty()) {
                ret.add(list);
            }
        }


        return ret;
    }


    public static void main(String[] args) {

        int[][] matrix = {{1,2}, {3,2}, {4,2}, {5}};

        ProductionUnion productionUnion = new ProductionUnion();
        List<List<Integer>> ret = productionUnion.solve(matrix);
        for (List<Integer> list : ret) {
            for(Integer cur : list) {
                System.out.print(cur + ", ");
            }
            System.out.println();
        }

    }
}
