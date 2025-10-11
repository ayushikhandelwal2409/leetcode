class Solution {
    public int strStr(String haystack, String needle) {
        int n=needle.length();
        int start=0;
        for(int i=n;i<=haystack.length();i++){
            if(haystack.substring(start,i).equals(needle)){
                return start;
            }
            start++;
        }
        return -1;
    }
}