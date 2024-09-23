class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = len / 2; i >= 1; i--) {
            if (len % i == 0) {
                String substr = s.substring(0, i);
                boolean match = true;
                for (int j = i; j < len; j += i) {
                    if (!s.substring(j, j + i).equals(substr)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }
}