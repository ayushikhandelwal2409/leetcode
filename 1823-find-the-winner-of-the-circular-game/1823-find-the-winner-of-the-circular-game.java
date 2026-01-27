class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
        q.offer(i);
        }
        int c=0;
        while(q.size()>1){
            int val=q.poll();
            c++;
            if(c!=k){
                q.offer(val);
            }
            else if(c==k){
                c=0;
            }
        }
        return q.peek();
    }
}