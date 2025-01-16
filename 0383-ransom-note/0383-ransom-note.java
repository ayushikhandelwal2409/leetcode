class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            if(map2.containsKey(magazine.charAt(i))){
                map2.put(magazine.charAt(i),map2.get(magazine.charAt(i))+1);
            }
            else{
                map2.put(magazine.charAt(i),1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if (!map2.containsKey(ch) || map2.get(ch) <= 0) {
                return false; 
            }
            map2.put(ch, map2.get(ch) - 1);
        }
        return true;
    }
}