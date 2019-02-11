package 亚麻.TreeAndGraph;


/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class NumOfIsland {

    class UnionFind{
        int[] parent;
        int[] rank;
        int count;

        public UnionFind(int size) {
            this.parent = new int[size];
            this.rank = new int[size];

            for (int i = 0; i < size; ++i) {
                parent[i] = i;
            }
            count = 0;
        }


        public int find(int index) {
            int x = index;

            while(parent[x] != x) {
                x = parent[x];
            }

            //compress
            while (parent[index] != x) {
                int tmp = parent[index];
                parent[index] = x;
                index = tmp;
            }

            return x;
        }


        public void union(int x, int y) {
            int a = find(x), b = find(y);

            if (a != b) {
                if (rank[a] > rank[b]) {
                    parent[b] = a;
                    rank[a]++;
                } else {
                    parent[a] = b;
                    rank[b]++;
                }
                count--;
            }
        }
    }

    public int[] dirx = {0, 1, 0, -1};
    public int[] diry = {1, 0, -1, 0};

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int n = grid.length, m = grid[0].length;

        UnionFind uf = new UnionFind(n*m);

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == '1') {
                    uf.count++;
                    for (int k = 0; k < 4; ++k) {
                        int nx = i + dirx[k], ny = j + diry[k];
                        if (0 <= nx && nx < n && 0 <= ny && ny < m && grid[nx][ny] == '1') {
                            uf.union(i*m+j, nx*m+ny);
                        }
                    }

                }
            }
        }

        return uf.count;
    }
}
