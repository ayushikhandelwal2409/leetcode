class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        s=str(x)
        if x>=0:
            sr=s[::-1]
            z=int(sr)
            if z<=(2**31 - 1) and z>=(-2**31):
                return z
            else:
                return 0
        else:
            sr=s[:0:-1]
            t="-"+sr
            z=int(t)
            if z<=(2**31 - 1) and z>=(-2**31):
                return z
            else:
                return 0

        