class Solution(object):
    def mergeAlternately(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: str
        """
        s=""
        for i ,j in zip(word1,word2):
            s+=i
            s+=j
        if(len(word1)>len(word2)):
            d=len(word1)-len(word2)
            a=len(word1)-d
            s+=word1[a:]
        elif(len(word1)<len(word2)):
            d=len(word2)-len(word1)
            a=len(word2)-d
            s+=word2[a:]
        return s