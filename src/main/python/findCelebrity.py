"""
The knows API is already defined for you.
@param a, person a
@param b, person b
@return a boolean, whether a knows b
you can call Celebrity.knows(a, b)
"""


class Solution:
    # @param {int} n a party with n people
    # @return {int} the celebrity's label or -1
    def findCelebrity(self, n):
        # Write your code here
        c = 0
        for i in range(1,n):
            if Celebrity.knows(c,i):
                c = i
        print('possible c', c)
        for i in range(n):
            if i == c:
                continue
            if not Celebrity.knows(i,c):
                return -1
            if Celebrity.knows(c,i):
                return -1
        return c