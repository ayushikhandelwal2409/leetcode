class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        ArrayList<Character> list=new ArrayList<>();
        int max=0;
        int start = 0; 

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            while (list.contains(currentChar)) {
                list.remove(0); 
                start++; 
            }
            list.add(currentChar);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}