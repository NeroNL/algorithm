"""
Definition of Interval.
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    """
    @param intervals: interval list.
    @return: A new interval list.
    """
    def merge(self, intervals):
        # write your code here
        if not intervals:
            return []
        left, right, l = 0, 1, len(intervals)
        intervals = sorted(intervals,key = lambda x: x.start)
        while right < l:
            if intervals[right].start > intervals[left].end:
                left += 1
                intervals[left].start = intervals[right].start
                intervals[left].end = intervals[right].end
            else:
                intervals[left].end = max(intervals[right].end,intervals[left].end)
            right += 1
        return intervals[:left+1]