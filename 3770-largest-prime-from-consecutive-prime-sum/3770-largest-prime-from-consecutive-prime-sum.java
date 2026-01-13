class Solution {
    public int largestPrime(int n) {
        ArrayList<Integer> ll=new ArrayList<>();
        sieve(n,ll);
        HashSet<Integer> primeSet = new HashSet<>(ll);// using set because searching in list will cost in tle
        int sum=0;
        int max=0;
        for(int i=0;i<ll.size();i++){
            sum+=ll.get(i);
            if (sum > n) break;
            if(primeSet.contains(sum)){
                max=Math.max(max,sum);
            }
        }  
        return max;
    }
    public void sieve(int n,ArrayList<Integer> ll){
        boolean[] isprime=new boolean[n+1];
        Arrays.fill(isprime,true);
        isprime[0]=false;
        isprime[1]=false;
        for(int i=0;i*i<=n;i++){
            if(isprime[i]){
                for(int j=i*i;j<=n;j+=i){
                    isprime[j]=false;
                }
            }
        }
        for(int i=0;i<=n;i++){
            if(isprime[i]) ll.add(i);
        }
    }
}