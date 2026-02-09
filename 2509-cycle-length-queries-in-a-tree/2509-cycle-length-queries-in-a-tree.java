class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int k=queries.length;
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            int cnt=0;
            int a=queries[i][0];
            int b=queries[i][1];
            int max=Math.max(a,b);
            int min=Math.min(a,b);
            // while(max>min){
            //     max/=2;
            //     cnt++;
            // }
            while(min!=max){
                if(max>min){
                    max/=2;
                    //cnt++;
                }
                else{
                    min/=2;
                    //cnt++;
                }
                cnt++;
            }
            ans[i]=cnt+1;
        }
        return ans;
    }
}