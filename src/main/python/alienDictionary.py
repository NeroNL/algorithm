from heapq import heappop, heappush, heapify
class Solution:
    """
    @param words: a list of words
    @return: a string which is correct order
    """
    def alienOrder(self, words):
        # Write your code here
        graph = self.build_graph(words)
        return self.topo_order(graph)

    def build_graph(self, words):
        res = {}
        for w in words:
            for c in w:
                if c not in res:
                    res[c] = set()
        for w in range(1,len(words)):
            for c in range(min(len(words[w]), len(words[w-1]))):
                if words[w][c] != words[w-1][c]:
                    res[words[w-1][c]].add(words[w][c])
                    break
        return res

    def topo_order(self, graph):
        # print(graph)
        indegree = {node:0 for node in graph}
        for node in graph:
            for ngb in graph[node]:
                indegree[ngb] += 1
        queue = [node for node in indegree if indegree[node] == 0]
        heapify(queue)
        # print(queue)
        visited, res = set([]),""
        while queue:
            node = heappop(queue)
            res += node
            for ngb in graph[node]:
                if ngb not in visited:
                    visited.add(ngb)
                    heappush(queue, ngb)
        if len(res) == len(graph):
            return res
        return ""