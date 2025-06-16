class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        HashMap<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        int start=0,i=0;
        int stind=-1,endind=-1,min=-1;
        int formed=0,required = tCount.size();
        HashMap<Character, Integer> map = new HashMap<>();
        while(i<s.length()){
            char ch=s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (tCount.containsKey(ch) && map.get(ch).intValue()  == tCount.get(ch).intValue() ) {
            formed++;
            }
            while(start<=i && formed==required){
                ch=s.charAt(start);
                if(min==-1 || min>i-start+1){
                    min=i-start+1;
                    stind=start;
                    endind=i;
                }
                map.put(ch, map.get(ch) - 1);
                if (tCount.containsKey(ch) && map.get(ch).intValue() < tCount.get(ch).intValue()) {
                    formed--;
                }
                start++;
            }
            i++;
        }
        return min==-1?"":s.substring(stind,endind+1);
    }
}