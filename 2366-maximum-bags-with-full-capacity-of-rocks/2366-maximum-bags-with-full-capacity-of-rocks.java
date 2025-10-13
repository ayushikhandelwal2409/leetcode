class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[][] arr = new int[n][2];

        //[capacity, rocks]
        for (int i = 0; i < n; i++) {
            arr[i][0] = capacity[i];
            arr[i][1] = rocks[i];
        }

        // Sort by remaining capacity (capacity - rocks)
        Arrays.sort(arr, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

        int count = 0;

        for (int i = 0; i < n; i++) {
            int need = arr[i][0] - arr[i][1];

            if (need == 0) {
                count++; // already full
            } else if (additionalRocks >= need) {
                additionalRocks -= need;
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}