class Solution(object):
    def findDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        mp={}
        for ele in nums:
            if ele in mp:
                return ele
            else:
                mp[ele]=1