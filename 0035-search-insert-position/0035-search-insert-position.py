class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        s=0
        e=len(nums)-1
        while(s<=e):
            mid=s+(e-s)/2
            if target>nums[mid]:
                s=mid+1
            elif target<nums[mid]:
                e=mid-1
            else:
                return mid
        for i in nums:
            if target<i:
                return nums.index(i)
        else:
            return len(nums)


