class Solution:
    # @param {integer[]} nums
    # @return {integer[]}
    # http://gregable.com/2013/10/majority-vote-algorithm-find-majority.html
    def majorityElement(self, nums):
        count1, count2, number1, number2 = 0, 0, 0, 1
        if not nums:
            return []
        for n in nums:
            if number1 == n:
                count1 += 1
            elif number2 == n: 
                count2 += 1
            elif count1 == 0:
                count1, number1 = 1, n
            elif count2 == 0:
                count2, number2 = 1, n
            else:
                count1, count2 = count1 - 1, count2 - 1

        return [n for n in (number1, number2) if nums.count(n) > len(nums) /3]



a = [3,3,2,2,3,0,0,0]
solution = Solution()
print solution.majorityElement(a)
