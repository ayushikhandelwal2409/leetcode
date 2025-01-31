class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        if (len1 > len2) {
            return false;
        }
        
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }
        
        for (int i = 0; i < len1; i++) {
            s2Count[s2.charAt(i) - 'a']++;
        }
        
        if (Arrays.equals(s1Count, s2Count)) {
            return true;
        }
        
        for (int i = len1; i < len2; i++) {
            s2Count[s2.charAt(i) - 'a']++;
            s2Count[s2.charAt(i - len1) - 'a']--;
            
            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }
        }
        
        return false;
    }
}