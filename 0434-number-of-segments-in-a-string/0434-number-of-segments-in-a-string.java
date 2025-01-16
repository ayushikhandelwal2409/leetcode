class Solution {
    public int countSegments(String s) {
        if(s.length()==0) return 0;
        int c=0;
        for(int i=0;i<s.length();i++){
            if(i==s.length()-1 && s.charAt(s.length()-1)!=' ') c++;
            else if(s.charAt(i)!=' ' && s.charAt(i+1)==' ') c++;
        }
        //if(s.charAt(s.length()-2)!=' ' && s.charAt(s.length()-1)==' ') c++;
        return c;
    }
}