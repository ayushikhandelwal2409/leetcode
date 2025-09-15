class Solution {
    HashSet<Integer> isTravelNeeded = new HashSet<>();
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp=new int[days[days.length-1]+1];
        Arrays.fill(dp,-1);
        for (int day : days) {
            isTravelNeeded.add(day);
        }
        return  travelling(1,days,dp,costs);
        
    }
    public  int travelling(int i,int[] days,int[] dp,int[] costs){
        if(i>days[days.length-1]){
            return 0;
        }
        if(!isTravelNeeded.contains(i)){
            return travelling(i+1,days,dp,costs);
        }
        if(dp[i]!=-1) {
            return dp[i];
        }
        int oneDay = costs[0] + travelling(i + 1,days ,dp, costs);
        int sevenDay = costs[1] + travelling(i + 7,days ,dp, costs);
        int thirtyDay = costs[2] + travelling(i + 30,days, dp, costs);

        return dp[i]=Math.min(oneDay, Math.min(sevenDay, thirtyDay));
    }
}