class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);//handles width
        int n=envelopes.length;
        int[] lis = new int[n];
        int size = 0;

        for (int[] env : envelopes) {
            int h = env[1];

            int idx = Arrays.binarySearch(lis, 0, size, h);
            if (idx < 0) idx = -(idx + 1);

            lis[idx] = h;

            if (idx == size) size++;
        }

        return size;
    }
}
// Case 1: Element FOUND
// returns index (>= 0)

// Case 2: Element NOT FOUND
// returns -(insertionPoint) - 1