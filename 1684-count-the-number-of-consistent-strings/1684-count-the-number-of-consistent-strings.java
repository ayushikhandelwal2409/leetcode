class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int c=0;
        for(int i=0;i<words.length;i++){
            String s=words[i];
            boolean k=true;
            for(int j=0;j<s.length();j++){
                if (allowed.indexOf(s.charAt(j)) == -1){
                    k=false;
                    break;
                }
            }
            if(k)
                c++;
        }
        return c;
    }
}