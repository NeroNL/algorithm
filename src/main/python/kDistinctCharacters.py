class Solution:
    """
    @param s: a string
    @param k: an integer
    @return: the number of substrings there are that contain at least k distinct characters
    """
    def kDistinctCharacters(self, s, k):
        # Write your code here
        if not s:
            return 0
        if k > len(s):
            return 0
        start, end, result, l, char_map = 0,0,0, len(s), dict()
        for start in range(l):
            while len(char_map) < k and end < l:
                if s[end] not in char_map:
                    char_map[s[end]] = 1
                else:
                    char_map[s[end]] += 1
                end += 1
            if len(char_map) == k:
                result += (l- end + 1)
            char_map[s[start]] -= 1
            if char_map[s[start]] == 0:
                del char_map[s[start]]
        return result