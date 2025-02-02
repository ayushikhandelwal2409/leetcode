class Solution {
    public int longestMountain(int[] arr) {
        if(arr.length<3){
            return 0;
        }
        int l=0;
        int max=0;
        while(l<arr.length-2){
            int r=l;
            while(r<arr.length-1 && arr[r]<arr[r+1]){
                r++;
            }
            int peak=r;
            while(r<arr.length-1 && arr[r]>arr[r+1]){
                r++;
            }
            if(l<peak && peak<r){
                max=Math.max(max,r-l+1);
            }
           l=Math.max(peak,l+1);
        }
        return max;
    }
}