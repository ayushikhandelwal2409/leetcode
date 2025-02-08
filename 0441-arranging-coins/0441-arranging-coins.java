class Solution {
    public int arrangeCoins(int n) {
        int rows=0;
        long coins_used=0;
        while(coins_used+(rows+1)<=n){
            coins_used+=rows+1;
            rows++;
        }
        return rows;
    }
}