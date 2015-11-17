class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        m, n = len(nums1), len(nums2)
        if m > n:
            m, n, nums1, nums2 = n, m, nums2, nums1
        imin, imax, half = 0, m, (m + n + 1) / 2
        while imin <= imax:
            i = (imin + imax) / 2
            j = half - i
            if j > 0 and i < m and nums2[j - 1] > nums1[i]:
                imin = i + 1
            elif i > 0 and j < n and nums1[i - 1] > nums2[j]:
                imax = i - 1
            else:
                if i == 0:
                    num1 = nums2[j - 1]
                elif j == 0:
                    num1 = nums1[i - 1]
                else:
                    num1 = max(nums1[i - 1], nums2[j - 1])

                if (m + n) % 2 == 1:
                    return num1
                
                if i == m:
                    num2 = nums2[j]
                elif j == n:
                    num2 = nums1[i]
                else:
                    num2 = min(nums1[i], nums2[j])

                return (num1 + num2) / 2.0

solution = Solution()
nums1 = [1,3,4,5,8]
nums2 = [2,5,6,7,9]
print solution.findMedianSortedArrays(nums1, nums2)
