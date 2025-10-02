class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n=boxTypes.length;
        Arrays.sort(boxTypes,(a,b)-> b[1]-a[1]);
        int cur=0;
        int size=0;
        for(int i=0;i<n && size<truckSize ;i++){
            if(size+boxTypes[i][0]<=truckSize){
                cur+=boxTypes[i][0]*boxTypes[i][1];
                size+=boxTypes[i][0];
            }
            else{
                int s=truckSize-size;
                cur+=s*boxTypes[i][1];
                break;
            }
        }
        return cur;
    }
}