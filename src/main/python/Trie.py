class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_word = False

class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        node = self.root
        for w in word:
            if w not in node.children:
                node.children[w] = TrieNode()
            node = node.children[w]
        node.is_word = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        res = self.find(word)
        if not res:
            return False
        if not res.is_word:
            return False
        return True

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        res = self.find(prefix)
        if not res:
            return False
        return True

    def find(self, word):
        node = self.root
        for w in word:
            if w not in node.children:
                return None
            node = node.children[w]
        return node


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)