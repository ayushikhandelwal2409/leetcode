class Solution {
    int mod = 1_000_000_007;

    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        int n = inventory.length;
        int i = n - 1;
        long ans = 0;
        int cur = inventory[n - 1];
        while (orders > 0) {
            while (i >= 0 && inventory[i] == cur) { //check for same top value for diff balls
                i--;
            }
            int count = n-i-1;   // width
            int next = (i >= 0) ? inventory[i] : 0;
            long total = (long)(cur - next) * count;
            //if takes all balls
            if (total <= orders) {
                ans = (ans + value(cur, next + 1, count)) % mod;
                orders -= total;
            }//if takes partial balls  
            else {
                long full = orders / count;
                long rem = orders % count;
                ans = (ans + value(cur, cur - full + 1, count)) % mod;
                ans = (ans + rem * (cur - full)) % mod;
                break;
            }

            cur = next;
        }
        return (int) ans;
    }

    // sum from min to max, multiplied by cnt
    public long value(long max, long min, long cnt){
        long terms = max - min + 1;   
        return (max + min) * terms / 2 * cnt; //arithmetic msun
    }
}
