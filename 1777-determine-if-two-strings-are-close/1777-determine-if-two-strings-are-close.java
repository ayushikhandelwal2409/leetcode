class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        for(char c:word1.toCharArray()){
            map1.put(c,map1.getOrDefault(c,0) + 1);
        }
        for(char d:word2.toCharArray()){
            map2.put(d,map2.getOrDefault(d,0) + 1);
        }
        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }
        int[] count1 = new int[map1.size()];
        int[] count2 = new int[map2.size()];
        
        int index = 0;
        for (int count : map1.values()) {
            count1[index++] = count;
        }
        
        index = 0;
        for (int count : map2.values()) {
            count2[index++] = count;
        }
        Arrays.sort(count1);
        Arrays.sort(count2);

        return Arrays.equals(count1, count2);
    }
}