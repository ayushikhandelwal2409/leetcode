class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max=Integer.MIN_VALUE;
        int i=k-1;
        int j=cardPoints.length-1;
        int sum=0;
        for(int l=0;l<k;l++){
            sum+=cardPoints[l];
        }
        max=Math.max(max,sum);
        for(int l=0;l<k && i>=0 && j>=0;l++){
            sum-=cardPoints[i];
            sum+=cardPoints[j];
            i--;
            j--;
            max=Math.max(max,sum);
        }
        return max;
    }
}