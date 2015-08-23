class Solution(object):
    def isPalindrome(self, x):
        if (x % 10 == 0 and x > 0) or x < 0:
            return False
        right = 0
        while x > right:
            right = right * 10 + x % 10
            x /= 10
        if x == right or x == right / 10:
            return True
        else:
            return False

solution = Solution()
print solution.isPalindrome(0)
                                                    
