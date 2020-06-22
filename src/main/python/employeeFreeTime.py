"""
# Definition for an Interval.
class Interval:
    def __init__(self, start: int = None, end: int = None):
        self.start = start
        self.end = end
"""

class Solution:
    def employeeFreeTime(self, schedule: '[[Interval]]') -> '[Interval]':
        if not schedule:
            return []
        m,cur, res = [], 0, []
        for i in range(len(schedule)):
            for s in schedule[i]:
                m.append([s.start, 1])
                m.append([s.end, -1])
        m.sort()
        m_l = len(m)
        for i in range(m_l):
            cur += m[i][1]
            if cur == 0 and i < m_l - 1:
                start, end = m[i][0], m[i+1][0]
                if start != end:
                    res.append(Interval(start,end))
        return res