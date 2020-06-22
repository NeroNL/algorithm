from collections import deque
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if not wordList:
            return 0
        if endWord not in wordList:
            return 0
        w, visited = set(wordList), set([beginWord])
        queue = deque([(beginWord, 1)])
        while queue:
            word, step = queue.popleft()
            if word == endWord:
                return step
            for i in range(len(word)):
                for c in 'abcdefghijklmnopqrstuvwxyz':
                    if c == word[i]:
                        continue
                    next_w = word[:i] + c + word[i+1:]
                    if next_w in w and next_w not in visited:
                        visited.add(next_w)
                        queue.append((next_w, step+1))
        return 0