class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        //List<Integer> l=new ArrayList<>();
        int[][] tasks = new int[difficulty.length][2];
        for (int i = 0; i < difficulty.length; i++) {
            tasks[i][0] = difficulty[i];
            tasks[i][1] = profit[i];
        }
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));

        // Create an array to store the maximum profit up to each difficulty
        int[] maxp = new int[difficulty.length];
        maxp[0] = tasks[0][1];
        for (int i = 1; i < difficulty.length; i++) {
            maxp[i] = Math.max(maxp[i - 1], tasks[i][1]);
        }
        int sum=0;

        for(int i=0;i<worker.length;i++){
            int k=worker[i];
            int m=0;
            int n=difficulty.length-1;
            while(m<=n){
                int mid=(m+n)/2;
                if(k>=tasks[mid][0]){
                    m=mid+1;
                    
                }
                else{
                    n=mid-1;
                }
            }
            if(n>=0){
                sum+=maxp[n];
            }
        }
        return sum;
    }
}