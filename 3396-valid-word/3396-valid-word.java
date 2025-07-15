class Solution {
    public boolean isValid(String word) {
        if(word.length()<3) return false;
        boolean v=false;
        boolean c=false;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!Character.isLetterOrDigit(ch)) return false;
            if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z')){
                if(ch=='a' || ch=='e' ||ch=='i' ||ch=='o' ||ch=='u' || ch=='A' || ch=='E' ||ch=='I' || ch=='O' ||ch=='U'){
                    v=true;
                }
                else{
                    c=true;
                }
            }   
        }
        if(!(v && c)) return false;
        return true;
    }
}