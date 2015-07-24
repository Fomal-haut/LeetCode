class Solution:
    # @param {integer[]} nums
    # @param {nteger} k
    # @param {boolean}
    def containsNearbyDuplicate(self, nums, k):
        container = {}
        index = 0
        if nums is None or k == 0:
            return False

        for i in nums:
            if i in container:
                if index - container[i] <= k:
                    return True
                else:
                    container[i] = index
            else:
                container[i] = index
            index += 1
        return False

numbers = [1] 
solution = Solution()
result = solution.containsNearbyDuplicate(numbers,2)
print result





