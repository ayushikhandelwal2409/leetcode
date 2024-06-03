class Solution {
    public int mySqrt(int x) {
        
        long start = 1;
        long end = x;
        long result = 0;
        
        while (start <= end&&x>0) {
            long mid = (start + end) / 2;
            
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid < x) {
                start = mid + 1;
                result = mid;
            } else {
                end = mid - 1;
            }
        }
        
        return (int)result;
    }
}
