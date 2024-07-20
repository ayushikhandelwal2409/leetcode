class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        b=sorted(nums)
        a=set(b)
        l=[]
        for i in a:
            c=0
            for j in b:
                if j==i:
                    c+=1
            l.append(c)
        m=max(l)
        i=l.index(m)
        c=list(a)
        return c[i]