class Solution:
    """
    @param: source: A source string
    @param: target: A target string
    @return: An integer as index
    """
    def strStr2(self, source, target):
        # write your code here
        if source is None or target is None:
            return -1
        if not target:
            return 0
        base, seed = 100007, 31
        power, t_l, s_l, s_hash, t_hash = 1, len(target), len(source), 0,0
        for i in range(t_l):
            t_hash = (t_hash * seed + ord(target[i]) - ord('a')) % base
            # if t_hash < 0:
            #     t_hash += base
        for i in range(t_l - 1):
            power = (power * seed) % base
        for i in range(s_l):
            if i >= t_l:
                s_hash = (s_hash - power * (ord(source[i-t_l]) - ord('a'))) % base
            s_hash = (s_hash * seed + ord(source[i]) - ord('a')) % base
            # if s_hash < 0:
            #     s_hash += base
            if i >= t_l - 1 and s_hash == t_hash:
                return i - t_l + 1
        return -1