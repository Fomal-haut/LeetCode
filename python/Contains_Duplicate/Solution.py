class Solution:
	# @param {integer[]} nums
	# @return {boolean}
	def containsDuplicate(self, nums):
		s = set()
		for i in nums:
			if i in s:
				return True
			else:
				s.add(i)
		return False


numbers = (1,2,3)
solution=Solution()
result = solution.containsDuplicate(numbers)
print result
			            
