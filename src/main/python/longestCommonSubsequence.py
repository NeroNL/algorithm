class Solution:
    """
    @param A: A string
    @param B: A string
    @return: The length of longest common subsequence of A and B
    """
    def longestCommonSubsequence(self, A, B):
        # write your code here
        if not A or not B:
            return 0
        al, bl = len(A), len(B)
        dp = [[0 for _ in range(bl)] for _ in range(al)]
        for x in range(al):
            for y in range(bl):
                count = 0 if A[x] != B[y] else 1
                if x == 0 or y == 0:
                    dp[x][y] = count
                    continue
                if count:
                    dp[x][y] = dp[x-1][y-1] + 1
                else:
                    dp[x][y] = max(dp[x-1][y], dp[x][y-1])
        return dp[-1][-1]