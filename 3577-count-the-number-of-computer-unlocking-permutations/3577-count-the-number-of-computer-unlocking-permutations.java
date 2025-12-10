class Solution {
    static long MOD= 1_000_000_007L;
    public int countPermutations(int[] complexity) {
        int n=complexity.length;
        for (int i = 1; i < n; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
        }
        long fact = factorialMod(n - 1);
        return (int) fact;
    }
    public static  long factorialMod(int k) {
        long res = 1L;
        for (int i = 2; i <= k; i++) {
            res = (res * i) % MOD;
        }
        return res;
    }

}