class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        int[][] fractions = new int[n * (n - 1) / 2][2];
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                fractions[index][0] = arr[i];
                fractions[index][1] = arr[j];
                index++;
            }
        }

        Arrays.sort(fractions, (a, b) -> a[0] * b[1] - a[1] * b[0]);

        return fractions[k - 1];
    }
}