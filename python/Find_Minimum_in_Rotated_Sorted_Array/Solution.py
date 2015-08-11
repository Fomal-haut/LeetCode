#采用二分查找法，但是要注意边界条件和特殊情况
class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def findMin(self, nums):
        start, end = 0, len(nums) - 1
        while start < end:
            if end - start == 1:
                min = (nums[end] > nums[start] and nums[start] or nums[end])
                if min < nums[0]:
                    return min
                else:
                    return nums[0]
            pivot = (start + end) / 2
            if nums[pivot] >= nums[start]:
                start = pivot
            else:
                end = pivot
        return nums[end]

sol = Solution()
nums = [4,5,6,7,0,1,2]
print sol.findMin(nums)

                            
