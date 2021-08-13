import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * sweep line algo helps solve this problem
 */
public class Skyline {
    static class Node implements Comparable<Node> {
        // type = 1 => entering
        // type = -1 => leaving
        int index, h, type;
        public Node (int index, int h, int type) {
            this.index = index;
            this.h = h;
            this.type = type;
        }
        @Override
        public int compareTo(Node o) {
            // when entering, sort from highest to lowest
            // when leaving, sort from lowest to highest
            // this way help to eliminate incorrect points
            if (index == o.index) return -(type * h) + o.type * o.h;
            return index - o.index;
        }

        @Override
        public String toString() {
            return "index: " + index + ", h: " + h + ", type: " + type;
        }
    }

    public List<List<Integer>> getSkyline(int[][] bs) {
        int n = bs.length;
        Node[] arr = new Node[n*2];
        for (int i = 0, j = 0; i < n*2 && j < n; i+=2, j++) {
            arr[i] = new Node(bs[j][0], bs[j][2], 1);
            arr[i+1] = new Node(bs[j][1], bs[j][2], -1);
        }

        Arrays.sort(arr);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (Node node : arr) {
            //System.out.println(node);
            if (node.type == 1) {
                if (map.isEmpty() || node.h > map.lastKey()) ans.add(Arrays.asList(node.index, node.h));
                map.put(node.h, map.getOrDefault(node.h, 0)+1);
            } else {
                if (map.get(node.h) == 1) map.remove(node.h);
                else map.put(node.h, map.get(node.h)-1);

                if (!map.isEmpty() && node.h > map.lastKey()) ans.add(Arrays.asList(node.index, map.lastKey()));
                else if (map.isEmpty()) ans.add(Arrays.asList(node.index, 0));
            }
        }

        return ans;

    }
}
