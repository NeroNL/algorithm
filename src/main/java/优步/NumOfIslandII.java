package 优步;

import datastructures.UnionFind;

import java.util.ArrayList;
import java.util.List;


/**
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example:
 *
 * Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
 * Output: [1,1,2,3]
 * Explanation:
 *
 * Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
 *
 * 0 0 0
 * 0 0 0
 * 0 0 0
 * Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 *
 * 1 0 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
 *
 * 1 1 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
 *
 * 1 1 0
 * 0 0 1   Number of islands = 2
 * 0 0 0
 * Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
 *
 * 1 1 0
 * 0 0 1   Number of islands = 3
 * 0 1 0
 *
 * Follow up:
 *
 * Can you do it in time complexity O(k log mn), where k is the length of the positions?
 */

public class NumOfIslandII {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ret = new ArrayList<>();
        UnionFind uf = new UnionFind(m*n);

        for (int[] pos : positions) {
            int r = pos[0], c = pos[1];
            List<Integer> overlap = new ArrayList<>();

            if (r -1 >= 0 && uf.isValid((r-1) * n + c)) {
                overlap.add((r-1)*n+c);
            }
            if (r + 1 < m && uf.isValid((r+1) * n + c)) {
                overlap.add((r+1) * n + c);
            }
            if (c - 1 >= 0 && uf.isValid(r * n + c - 1)) {
                overlap.add(r * n + c - 1);
            }
            if (c + 1 < n && uf.isValid(r * n + c + 1)) {
                overlap.add(r * n + c + 1);
            }

            int index = r * n + c;
            uf.setParent(r*n+c);
            for (int i : overlap) {
                uf.union(i, index);
            }
            ret.add(uf.getCount());
        }

        return ret;
    }


    public static void main(String[] args) {

        int[][] test = {{0,0}, {0,1}, {1,2}, {2,1}};

        NumOfIslandII k = new NumOfIslandII();

        for (Integer i : k.numIslands2(3, 3, test )) {
            System.out.println("count: " + i);
        }
    }

}
