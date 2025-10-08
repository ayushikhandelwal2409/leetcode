class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        int[] start = new int[n];
        int[] end = new int[n];
        
        for (int i = 0; i < n; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int[] res = new int[people.length];
        
        for (int i = 0; i < people.length; i++) {
            int t = people[i];
            int started = upperBound(start, t);   // flowers that started ≤ t
            int ended = lowerBound(end, t);       // flowers that ended < t
            res[i] = started - ended;
        }
        
        return res;
    }
    
    // Finds index of first element > target
    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    // Finds index of first element >= target
    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}