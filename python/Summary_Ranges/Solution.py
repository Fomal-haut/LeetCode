class Solution:
    # @param {integer[]} nums
    # @return {string[]}
    def summaryRanges(self, nums):
        if len(nums) == 0:
            return []
        start = nums[0] 
        result = []
        flag = True
        for i in range(len(nums)):
            if i == 0:
                pass
            elif nums[i] - nums[i-1] != 1:
                flag = False
                if start == nums[i-1]:
                    result.append(str(start)) 
                else:
                    result.append(str(start) + "->" + str(nums[i-1]))
                start = nums[i]
                if i == len(nums) - 1:
                    result.append(str(start))
            else:
                flag = True
        if flag == True:
            if start == nums[len(nums) -1]:
                result.append(str(start)) 
            else:
                result.append(str(start) + "->" + str(nums[len(nums) - 1]))
        return result

numbers = [-1]
sol = Solution()
print sol.summaryRanges(numbers)




                            
