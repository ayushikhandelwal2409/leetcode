class Solution(object):
    def convertToTitle(self, columnNumber):
        """
        :type columnNumber: int
        :rtype: str
        """
        result = ""
        while columnNumber > 0:
            columnNumber, remainder = divmod(columnNumber - 1, 26)
            result = chr(65 + remainder) + result
        return result
