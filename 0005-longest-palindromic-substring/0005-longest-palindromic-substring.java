//brute force
class Solution {
    public String longestPalindrome(String s) {
        String k="";
        int len=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(check(s.substring(i,j+1))){
                    if(len<(j-i+1)){
                        k=s.substring(i,j+1);
                        len=(j - i + 1);
                    }
                }

            }
        }
        return k;
    }
    public static boolean check(String s){
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}