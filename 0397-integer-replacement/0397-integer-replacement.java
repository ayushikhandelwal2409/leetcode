class Solution {
    public int integerReplacement(int n) {
        HashMap<Long, Integer> dpmap=new HashMap<>();
        return operation_count(n,dpmap);
    }
    public int operation_count(long n,HashMap<Long, Integer> dpmap){
        if(n==1) return 0;
        if (dpmap.containsKey(n)) return dpmap.get(n);
        int even = Integer.MAX_VALUE;
        int oddminus = Integer.MAX_VALUE;
        int oddplus = Integer.MAX_VALUE;
        if(n%2==0) even=1+operation_count(n/2,dpmap);
        else{
             oddplus=1+operation_count(n+1,dpmap);
             oddminus=1+operation_count(n-1,dpmap);
        }
        int ans=Math.min(even, Math.min(oddminus, oddplus));
        dpmap.put(n, ans);
        return ans;

    }
}