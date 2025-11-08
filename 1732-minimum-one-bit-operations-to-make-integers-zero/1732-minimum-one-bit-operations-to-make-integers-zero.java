class Solution {
    public int minimumOneBitOperations(int n) {
        int c=0;
        while(n>0){
            c^=n;
           n= n>>1;
            //c++;
        }
        return c;
    }
}