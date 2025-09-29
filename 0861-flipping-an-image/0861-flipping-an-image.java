class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i=0;i<image.length;i++){
            int j=0, k=image[0].length-1;
            while(j<=k){
                int temp=image[i][j];
                image[i][j]=image[i][k];
                image[i][k]=temp;
                image[i][k]^=1;
                image[i][j]^=1;
                j++;k--; 
            }
            if((image[i].length-1)%2==0){
                image[i][(image[i].length-1)/2]^=1;
            }
        }
        return image;
    }
}