class Solution:
    # @param {integer[]} nums
    # @return {integer[]}
    def productExceptSelf(self, nums):
        left = [1]
        leftSum = 1
        for i in nums:
            leftSum *= i
            left.append(leftSum)
        right = [1]
        rightSum = 1
        nums.reverse()
        for j in nums:
            rightSum *= j 
            right.append(rightSum)
        result = []
        for i in range(len(nums)):
            result.append(left[i] * right[len(nums) - i -1])
        return result

sol = Solution()
numbers = [1,2,3,4]
print sol.productExceptSelf(numbers)


                
