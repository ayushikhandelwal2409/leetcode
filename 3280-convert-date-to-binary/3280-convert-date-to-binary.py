import math
class Solution(object):
    def convertDateToBinary(self, date):
        """
        :type date: str
        :rtype: str
        """
        l=date.split("-")
        l1=[]
        for i in l:
            l=len(i)
            s1=""
            k=int(i)
            while(k>0):
                r=k%2
                s1=str(r)+s1
                k=k/2
            l1.append(s1)
        return "-".join(l1)
        
            