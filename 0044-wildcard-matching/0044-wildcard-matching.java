class Solution {
    public boolean isMatch(String s, String p) {
        int i=0;//s
        int j=0;//p
        int lastStar = -1;  // last position of '*' in p
        int lastMatch = 0; // position in s when '*' was found
         while (i < s.length()) {
            // Case 1: if current chars match or pattern has '?'
            if (j < p.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')) {
                i++;
                j++;
            }
            // Case 2: pattern has '*'
            else if (j < p.length() && p.charAt(j) == '*') {
                lastStar = j;   // mark position of '*'
                lastMatch = i;      // mark position in s
                j++;           // move pattern pointer ahead
            }
            // Case 3: mismatch but we had a previous '*'
            else if (lastStar != -1) {
                j = lastStar + 1;  // backtrack pattern to after '*'
                lastMatch++;           // let '*' absorb one more char
                i = lastMatch;         // move i forward
            }
            // Case 4: no match and no '*' to backtrack to
            else {
                return false;
            }
        }

        // After finishing s, pattern may still have trailing '*'
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        // True only if entire pattern is used up
        return j == p.length();
    }
}