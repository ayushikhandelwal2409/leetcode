class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n=fruits.length;
        int m=baskets.length;
        int[] vis=new int[m];
        int[] check=new int[n];
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[j]!=1){
                    if(fruits[i]<=baskets[j]){
                        vis[j]=1;
                        check[i]=1;
                        break;
                    }
                }
            }
        }
        for(int k:check){
            if(k==0) c++;
        }
        return c;
    }
}