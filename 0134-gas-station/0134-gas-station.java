class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sg=0;
        int sc=0;
        for(int i=0;i<cost.length;i++){
            sg+=gas[i];
            sc+=cost[i];
        }
        if(sc>sg) return -1;
        int in=0;
        int rem=0;
        for(int j=0;j<cost.length;j++){
            rem+=gas[j]-cost[j];
            if(rem<0){
                rem=0;
                in=j+1;
            }
        }
        return in;
    }
}