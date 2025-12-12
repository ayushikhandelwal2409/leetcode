class Solution {
    public int minimumOneBitOperations(int n) {
        int c=0;
        while(n>0){
            c^=n;
           n= n>>1;
        //    System.out.println(n);
        //     System.out.println(c);
        }
        return c;
    }
}