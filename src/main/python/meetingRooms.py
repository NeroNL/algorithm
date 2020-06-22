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
    @return: if a person could attend all meetings
    """
    def canAttendMeetings(self, intervals):
        # Write your code here
        if not intervals:
            return True
        ml, count = [], 0
        for i in intervals:
            ml.append([i.start, 1])
            ml.append([i.end, -1])
        ml.sort()
        for m in ml:
            count += m[1]
            if count > 1:
                return False
        return True