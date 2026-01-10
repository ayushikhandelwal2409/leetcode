class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if(k*m>n) return -1;
        int e = 0;
        int s=0;
        for (int day : bloomDay) {
            e = Math.max(e, day);
        }
        int days=-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(ispossible(m,k,mid,bloomDay)>=m){
                days=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return days;
    }
    public static int ispossible(int m,int k,int day,int[] bloomday){
        int bou=0;
        int flowers=0;
        for(int i=0;i<bloomday.length;i++){
            if(bloomday[i]<=day){
                flowers++;
                if(flowers==k){
                    bou++;
                    flowers=0;
                }
            }
            else{
                flowers=0;
            }
        }
        return bou;
    }
}