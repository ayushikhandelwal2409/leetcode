class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        n=""
        for i in s:
            if (i>="a" and i<="z") or (i>="A" and i<="Z") or (i>="0" and i<="9"):
                n+=i.lower()
        return n==n[::-1]
        
        