class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map1=new HashMap<>();
        HashMap<String,Character> map2=new HashMap<>();
        String[] arr=s.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        for(int i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);
            String word=arr[i];
            if(map1.containsKey(ch)){
                if(!map1.get(ch).equals(word)){
                    return false;
                }
            }
            else{
                map1.put(ch,word);
            }
            if(map2.containsKey(word)){
                if(!map2.get(word).equals(ch)){
                    return false;
                }
            }
            else{
                map2.put(word,ch);
            }
        }
        return true;
    }
}