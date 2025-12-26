class Solution {
    public long minEnd(int n, int x) {
        long result= x;
        while(n-1>0){
            result=x|(result+1);
            n--;
        }
        return result;
    }
}