class Solution(object):
    def kthDistinct(self, arr, k):
        """
        :type arr: List[str]
        :type k: int
        :rtype: str
        """
        l=[]
        for i in range(len(arr)):
            if arr.count(arr[i])==1:
                l.append(arr[i])
            else:
                pass
        if len(l)>=k:
            return l[k-1]
        return ""
        