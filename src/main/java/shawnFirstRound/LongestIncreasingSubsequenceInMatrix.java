package shawnFirstRound;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class LongestIncreasingSubsequenceInMatrix {

    static class Node {
        int num, len;
        public Node (int num, int len) {
            this.num = num;
            this.len = len;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()), m = Integer.parseInt(scanner.nextLine());

        int[][] arr = new int[n][m];

        for (int i = 0 ; i < n; ++i) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < m; ++j) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        Comparator<Node> comparator = (o1, o2) -> o1.num - o2.num;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int j = 0; j < m; ++j) map.put(arr[0][j], 1);
        int ans = 1;

        for (int i = 1; i < n; ++i) {
            TreeMap<Integer, Integer> tmp = new TreeMap<>();
            for (int j = 0; j < m; ++j) {
                Integer cur = arr[i][j];
                Integer key = map.floorKey(cur);
                while(key != null) {
                    tmp.put(cur, map.get(key)+1);
                    key = map.floorKey(cur);
                }
            }
        }
    }
}
