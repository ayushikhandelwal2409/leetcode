class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l=flowerbed.length;
        if (n==0){
            return true;
        }
        //if (l == 1) return (flowerbed[0] == 0 && n <= 1) || n == 0;

        for (int i = 0; i < l  && n > 0; i++) {
            if (flowerbed[i] == 0) {
                boolean emptyLeft = (i == 0) || (flowerbed[i - 1] == 0);
                boolean emptyRight = (i == l - 1) || (flowerbed[i + 1] == 0);

                if (emptyLeft && emptyRight) {
                    flowerbed[i] = 1;
                    n--;
                    i++;
                }
            }
        }
        return n==0;
    }
}