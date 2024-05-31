class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        s=""
        for i in digits:
            s+=str(i)
        n=int(s)
        t=str(n+1)
        l1=[]
        for j in t:
            l1.append(int(j))
        return l1
        
        