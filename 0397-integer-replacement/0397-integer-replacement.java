class Solution {
    public int integerReplacement(int n) {
        long num = n; // use long to avoid overflow at Integer.MAX_VALUE
        int cnt = 0;
        
        while (num >1) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                // if n == 3 or n % 4 == 1 → subtract 1, else add 1
                if (num == 3 || (num%4)==1) {
                    num = num - 1;
                } else {
                    num = num + 1;
                }
            }
            cnt++;
        }
        
        return cnt;
    }
}
// class Solution {
//     public int integerReplacement(int n) {
//         HashMap<Long, Integer> dpmap=new HashMap<>();
//         return operation_count(n,dpmap);
//     }
//     public int operation_count(long n,HashMap<Long, Integer> dpmap){
//         if(n==1) return 0;
//         if (dpmap.containsKey(n)) return dpmap.get(n);
//         int even = Integer.MAX_VALUE;
//         int oddminus = Integer.MAX_VALUE;
//         int oddplus = Integer.MAX_VALUE;
//         if(n%2==0) even=1+operation_count(n/2,dpmap);
//         else{
//              oddplus=1+operation_count(n+1,dpmap);
//              oddminus=1+operation_count(n-1,dpmap);
//         }
//         int ans=Math.min(even, Math.min(oddminus, oddplus));
//         dpmap.put(n, ans);
//         return ans;

//     }
// }