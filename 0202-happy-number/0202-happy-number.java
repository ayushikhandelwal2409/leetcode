class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)){
            seen.add(n);
            n=check(n);
        }
        return n==1;
    }
    public static int check(int k){
        int sum=0;
        while(k>0){
            int r=k%10;
            sum += r * r;
            k=k/10;
        }
        
        return sum;
    }
}