class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        int length = 0;
        boolean hasOddCount = false;
        
        for (int count : charCount.values()) {
            if (count % 2 == 0) {
                length += count; 
            } else {
                length += count - 1; 
                hasOddCount = true; 
            }
        }
        
        if (hasOddCount) {
            length += 1;
        }
        
        return length;
    }
}