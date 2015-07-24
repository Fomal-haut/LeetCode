class Solution:
    # @param nums, an integer[]
    # @return an integer
    def findPeakElement(self, nums):
        for i in range(len(nums)):
            if i == 0 or nums[i] > nums[i-1]:
                if i == len(nums) - 1 or nums[i] > nums[i+1]:
                    return i 

numbers=[1,2,3,7,4,5,6]
sol = Solution()
result = sol.findPeakElement(numbers)
print result

