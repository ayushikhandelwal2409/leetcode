class Solution(object):
    def minimumPushes(self, word):
        """
        :type word: str
        :rtype: int
        """
        freq = {}
        for char in word:
            if char in freq:
                freq[char] += 1
            else:
                freq[char] = 1
        sorted_freq = sorted(freq.values())
        sorted_freq.reverse()
        pushes = 0
        for i in range(len(sorted_freq)):
            pushes += (i // 8 + 1) * sorted_freq[i]

        return pushes