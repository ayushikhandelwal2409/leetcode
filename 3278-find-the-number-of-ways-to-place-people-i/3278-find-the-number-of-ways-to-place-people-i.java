class Solution {
    public int numberOfPairs(int[][] points) {//pa=point a ,  pb=point b
        int c=0;
        int n=points.length;
        for(int i=0;i<n;i++){
            int[] pa=points[i];
            for(int j=0;j<n;j++){
                int[] pb =points[j];
                if(i==j) continue;
                if(!(pa[0] <= pb[0] && pa[1] >= pb[1])){
                    continue;
                }
                if(n==2) {
                    c++;
                    continue;
                }
                boolean check=false;
                for(int k=0;k<n;k++){
                    int[] newp=points[k];
                    if(k==i || k==j) continue;
                    boolean check_coordinate_x=newp[0]>=pa[0] && newp[0]<=pb[0];
                    boolean check_coordinate_y=newp[1]<=pa[1] && newp[1]>=pb[1];
                    if( check_coordinate_x &&  check_coordinate_y){
                        check=true;
                        break;
                    }
                }
                if(!check){
                    c++;
                }
            }
        } 
        return c;  
    }
}