class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s=1;
        int e=0;
        for(int pile:piles){
            e=Math.max(e,pile);
        }
        while(s<e){
            int mid=s+(e-s)/2;
            if(canEat(piles,h,mid)){
                e=mid;
            }
            else{
                s=mid+1;
            }
        }
        return s;
    }
    public static boolean canEat(int[] piles ,int h,int k){
        int hours_needed=0;
        for(int pile:piles){
            hours_needed+=Math.ceil(pile/(double)k);
        }
        return hours_needed<=h;
    }
}