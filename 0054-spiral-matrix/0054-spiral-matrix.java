class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list= new ArrayList<>();
        int r=matrix.length;
        int c=matrix[0].length;
        int top = 0;
        int bottom = r - 1;
        int left = 0;
        int right = c - 1;
        int te=r*c;
        while(te>0){
            for(int i=left;i<=right;i++){
                list.add(matrix[top][i]);
                te--;
            }
            top++;
            if(top>bottom)break;
            for(int i=top;i<=bottom;i++){
                list.add(matrix[i][right]);
                te--;
            }
            right--;
            if(left>right)break;
            for(int i=right;i>=left;i--){
                list.add(matrix[bottom][i]);
                te--;
            }
            bottom--;
            if(top>bottom)break;
            for(int i=bottom;i>=top;i--){
                list.add(matrix[i][left]);
                te--;
            }
            left++;
        }
        return list;
    }
}