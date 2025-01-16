class Solution {
    public boolean detectCapitalUse(String word) {
        int c=0;
        int s=0;
        int l=word.length();
        for(int i=0;i<l;i++){
            char ch=word.charAt(i);
            if(ch>='a' && ch<='z'){
                s++;
            }
            if(ch>='A' && ch<='Z'){
                c++;
            }
        }
        if(l==s || l==c) return true;
        if( word.charAt(0)>='A' && word.charAt(0)<='Z' && c==1 && s==l-1) return true;
        return false;
    }
}