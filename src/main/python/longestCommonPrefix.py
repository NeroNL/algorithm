class TrieNode:
    def __init__(self):
        self.children = {}
        self.pre = ""

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        # print(word,'start')
        if not word:
            node.children[word] = TrieNode()
        for w in word:
            # print('w',w)
            if w not in node.children:
                node.children[w] = TrieNode()
                node.children[w].pre = w
            node = node.children[w]

    def find(self):
        node = self.root
        res = []
        while node.children:
            if len(node.children) > 1:
                return res
            node = list(node.children.values())[0]
            res.append(node.pre)
        return res

class Solution:
    """
    @param strs: A list of strings
    @return: The longest common prefix
    """
    def longestCommonPrefix(self, strs):
        # write your code here
        trie = Trie()
        for word in strs:
            trie.insert(word)
        res = trie.find()
        return "".join(res)