class Solution {
    public long minEnd(int n, int x) {
        long result= x;
        while(n-1>0){// we use n-1 b'coz from n len we have already one element as x
            result=x|(result+1);
            n--;
        }
        return result;
    }
}