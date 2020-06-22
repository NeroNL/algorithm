import sys
class Solution:
    """
    @param grid: a 2D grid
    @return: An integer
    """
    def shortestDistance(self, grid):
        # write your code here
        if not grid or not grid[0]:
            return -1
        xl, yl = len(grid), len(grid[0])
        x_sum = [sum(grid[x]) for x in range(xl)]
        x_count = [0 for _ in range(xl)]
        for xa in range(xl):
            count = 0
            for xb in range(xl):
                count += abs(xa-xb) * x_sum[xb]
            x_count[xa] = count
        y_sum = [0 for _ in range(yl)]
        y_count = [0 for _ in range(yl)]
        for y in range(yl):
            total = 0
            for x in range(xl):
                total += grid[x][y]
            y_sum[y] = total
        for ya in range(yl):
            count = 0
            for yb in range(yl):
                count += abs(yb-ya) * y_sum[yb]
            y_count[ya] = count
        print(x_count, y_count)
        res = sys.maxsize
        for x in range(xl):
            for y in range(yl):
                if grid[x][y] == 1:
                    continue
                res = min(x_count[x] + y_count[y],res)
        return res