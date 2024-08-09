class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        c=int(a,2)  # Convert binary string a to decimal integer
        d=int(b,2)  # Convert binary string b to decimal integer
        s=c+d  # Add the two decimal integers
        l=bin(s)[2:]  # Convert the sum back to binary string and remove the '0b' prefix
        return l  # Print the result