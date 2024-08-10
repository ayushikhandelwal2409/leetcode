class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        n=""
        for i in s:
            if i.isalnum():
                n += i.lower()
        return n==n[::-1]
        
        