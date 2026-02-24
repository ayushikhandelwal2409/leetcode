class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int n= numCourses;
        int[][] mat=new int[n][n];
        for(int[] k:mat){
            Arrays.fill(k,(int)1e8);
        }
        for(int[] k:prerequisites){
            mat[k[0]][k[1]]=1;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <n ; j++) {
                    if (mat[i][k] < 1e8 && mat[k][j] < 1e8){
                        mat[i][j] = Math.min(mat[i][k] + mat[k][j], mat[i][j]);
                    }
                }
            }
        }
        ArrayList<Boolean> ll=new ArrayList<>();
        for (int[] q:queries) {
            int i=q[0];
            int j=q[1];
            if (mat[i][j] == 1e8) {
                //prerequisites[i][j] = -1;
                ll.add(false);
            }else{
                ll.add(true);
            }
        }
        return ll;
    }
}  