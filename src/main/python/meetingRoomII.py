"""
Definition of Interval.
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    """
    @param intervals: an array of meeting time intervals
    @return: the minimum number of conference rooms required
    """
    def minMeetingRooms(self, intervals):
        # Write your code here
        if not intervals:
            return 0
        mt, res, cur= [], 0, 0
        for i in intervals:
            mt.append([i.start, 1])
            mt.append([i.end, -1])
        mt.sort()
        for m in mt:
            cur += m[1]
            res = max(res, cur)
        return res