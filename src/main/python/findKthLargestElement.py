class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        n = len(nums)
        return self.partition(0,n-1, nums, n-k)


    def partition(self, start, end, nums, k):
        left, right = start, end
        mid = nums[left]
        while left <= right:
            while left <= right and nums[left] < mid:
                left += 1
            while left <= right and nums[right] > mid:
                right -= 1
            if left <= right:
                nums[left],nums[right] = nums[right], nums[left]
                left += 1
                right -= 1
        if k <= right:
            return self.partition(start, right, nums, k)
        if k >= left:
            return self.partition(left, end, nums, k)
        return nums[k]