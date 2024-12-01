class Solution {
    public double myPow(double x, int n) {
        double k=1.0;
        long power=n;
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }
        while (power > 0) {
            if (power % 2 == 1) { // If n is odd
                k *= x; // Multiply result by x
            }
            x *= x; // Square the base
            power /= 2; // Divide n by 2
        }
        return k;
    }
}