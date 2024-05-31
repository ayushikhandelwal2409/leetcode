class Solution(object):
    def longestCommonPrefix(self, strs): 
        prefix = strs[0]
    
        # Compare the prefix with each string in the list
        for s in strs[1:]:
            # Reduce the prefix until it matches the start of the string s
            while s[:len(prefix)] != prefix:
                prefix = prefix[:-1]
                # If the prefix becomes empty, return ""
                if not prefix:
                    return ""
        
        return prefix