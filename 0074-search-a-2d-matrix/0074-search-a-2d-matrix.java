class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {// binary search
       int m = matrix.length;
        int n = matrix[0].length;
        
        int left = 0, right = m * n - 1;  // Treat as 1D array
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / n][mid % n]; // map 1D index to 2D row, col
            
            if (midValue == target) return true;
            else if (midValue < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}