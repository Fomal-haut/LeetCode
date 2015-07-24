class Solution:
    # @param {integer} s
    # @param {integer[]} nums
    # @return {integer}
    # 双指针，采用滑动窗口的方式
    def minSubArrayLen(self, s, nums):
        sum = start = end = 0
        minLength = 100000
        while end < len(nums):
            while end < len(nums) and sum < s:
                sum += nums[end]
                end += 1
            if sum < s:
                break
            while start < end and sum >= s:
                sum -= nums[start]
                start += 1
            if end - start + 1 < minLength:
                minLength = end -start + 1
        return minLength != 100000 and minLength or 0 

number = []
sol = Solution()
print sol.minSubArrayLen(100, number)


