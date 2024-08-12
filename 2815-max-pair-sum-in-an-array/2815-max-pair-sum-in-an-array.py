class Solution(object):
    def maxSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l=[]
        d={}
        for i in nums:
            m=[]
            while(i>0):
                r=i%10
                m.append(r)
                i=i//10
            l.append(max(m))
        for i in l:
            if i in d:
                d[i]+=1
            else:
                d[i]=1
        k=[]
        for i in d:
            if d[i]>=2:
                k.append(i)
        maxx=[]
        for i in k:
            c=[]
            s=0
            q=0
            for j in l:
                q+=1
                if i==j:
                    c.append(nums[q-1])
            if len(c)<=2:
                s+=sum(c)
            else:
                v=sorted(c)
                s+=v[-1]
                s+=v[-2]
            maxx.append(s)
        if len(maxx)==0:
            return -1
        else:
            return max(maxx)
                