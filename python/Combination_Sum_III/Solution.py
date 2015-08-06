class Solution:
    # @param {integer} k
    # @param {integer} n
    # @return {integer[][]}
    result = []

    def calculator(self, k, currentList, val):
        if k == 0 and val != 0:
            return
        elif k != 0 and len(currentList) != 0 and val <= currentList[len(currentList) - 1]:
            return
        elif k == 0 and val == 0:
            Solution.result.append(list(currentList))
        else:
            start = 1 if not currentList else currentList[len(currentList) - 1] + 1
            end = min(val+1,10)
            for w in range(start, end):
                currentList.append(w)
                self.calculator(k-1, currentList, val-w)
                currentList.remove(w)


    def combinationSum3(self, k, n):
        Solution.result = []
        currentList = []
        self.calculator(k, currentList, n)
        return Solution.result

sol = Solution()
print sol.combinationSum3(3,7)
