class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return []
        res, used = [], [False for _ in range(len(nums))]
        self.dfs(nums, used , [],res)
        return res

    def dfs(self, nums, used, path, res):
        if len(path) == len(nums):
            if path[:] not in res:
                res.append(path[:])
            return
        for i in range(len(nums)):
            if used[i] or (i > 0 and not used[i-1] and nums[i] == nums[i-1]):
                continue
            used[i] = True
            self.dfs(nums, used, path + [nums[i]], res)
            used[i] = False
        return
