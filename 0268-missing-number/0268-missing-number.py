class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n=0
        for i in range(1,len(nums)+1):
            if i in nums:
                pass
            else:
                n=i
        return n