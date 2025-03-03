class Solution {
    public String longestPalindrome(String s) {
        StringBuilder k=new StringBuilder();
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length()-i;j++){
                if(check(s.substring(j,j+i+1))){
                    if(k.length()<len(s.substring(j,j+i+1))){
                        k.setLength(0);
                        k.append(s.substring(j,j+i+1));
                    }
                }

            }
        }
        return k.toString();
    }
    public static int len(String s){
        return s.length();
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