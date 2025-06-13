class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int count=0,start=0,i=0;
        while(i<s.length()){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
            while (map.size() == 3) {
                // Counting the number of valid substrings
                count += s.length() - i;
                // Removing the character at the start of the window
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                if (map.get(startChar) == 0) {
                    map.remove(startChar);
                }
                start++;
            }
            i++;
        }
        return count;
    }
}