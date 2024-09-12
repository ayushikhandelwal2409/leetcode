class Solution {
    public int similarPairs(String[] words) {
        int c = 0;
        for (int i = 0; i < words.length-1; i++) {
            for(int k = i+1; k< words.length; k++){
                String allowed=words[i];
                String s = words[k];
                if(cs(allowed,s)){
                    c++;
                }
            }
        }
        return c;
    }

    public static boolean cs(String s, String t){
        Set<Character> sSet = new HashSet<>();
        for (char ch : s.toCharArray()){
            sSet.add(ch);
        }
        Set<Character> tSet =new HashSet<>();
        for(char ch : t.toCharArray()){
            tSet.add(ch);
        }
        if(sSet.equals(tSet))
            return true;
        return false;
    }
}