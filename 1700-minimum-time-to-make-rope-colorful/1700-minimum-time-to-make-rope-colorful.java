class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n=colors.length();
        if(n==1) return 0;
        int ans=0;
        for(int i=1;i<n;i++){
            char a=colors.charAt(i-1);
            char b=colors.charAt(i);
            if(a==b){
                ans+=Math.min(neededTime[i-1],neededTime[i]);
                neededTime[i]=Math.max(neededTime[i-1],neededTime[i]);
            }
        }
        return ans;
    }
}