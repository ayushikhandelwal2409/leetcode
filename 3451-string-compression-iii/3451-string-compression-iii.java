class Solution {
    public String compressedString(String word) {
        String s="";
        char c=word.charAt(0);
        int ct=1;
        for(int i=1;i<word.length();i++){
            if(word.charAt(i)==c &&ct<9){
                ct++;
            }else{
                s+=ct;
                s+=c;
                c=word.charAt(i);
                ct=1;
            }
        }
        s+=ct;
        s+=c;
        return s;
    }
}