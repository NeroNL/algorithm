class Solution:
    """
    @param s: a string
    @return: return a integer
    """
    def longestValidParentheses(self, s):
        # write your code here
        if not s:
            return 0
        stack,ans = [-1], 0
        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)
            else:
                stack.pop()
                if stack:
                    ans = max(ans, i - stack[-1])
                else:
                    stack.append(i)
        return ans