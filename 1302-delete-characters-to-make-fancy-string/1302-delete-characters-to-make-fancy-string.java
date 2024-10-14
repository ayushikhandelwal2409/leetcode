class Solution {
    public String makeFancyString(String s) {
        StringBuilder s1 = new StringBuilder();
        s1.append(s.charAt(0));
        int c = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i-1)) {
                c = 1;
            } else {
                c++;
            }
            if (c < 3) {
                s1.append(s.charAt(i));
            }
        }
        return s1.toString();
    }
}