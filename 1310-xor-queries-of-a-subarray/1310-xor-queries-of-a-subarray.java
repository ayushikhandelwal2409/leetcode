class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] l = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] t = queries[i];
            int left = t[0];
            int right = t[1];
            int c = 0;
            for (int j = left; j <= right; j++) {
                c ^= arr[j];
            }
            l[i] = c;
        }
        return l;
    }
}