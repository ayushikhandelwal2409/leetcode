class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n=deck.length;
        int[] ans=new int[n];
       // ArrayList<Integer> l=new ArrayList<>();
        Arrays.sort(deck);
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            q.add(i);
        }
        int c=0;
        while(!q.isEmpty()){
            int val=q.poll();
         //   l.set(c,val);
            ans[val]=deck[c];
            c++;
            if(!q.isEmpty()){
                q.offer(q.poll());
            }

        }
        return ans;
    }
}