class Solution {
    static class BinaryTrie{
        class Node{
            Node zero;
            Node one;
        }
        private Node root=new Node();
        public void add(int val){
            Node curr=root;
            for(int i=31;i>=0;i--){
                int bit=val&(1<<i);
                if(bit==0){
                    if(curr.zero!=null){
                        curr=curr.zero;
                    }else{
                        Node nn=new Node();
                        curr.zero=nn;
                        curr=nn;
                    }
                }
                else{
                    if(curr.one!=null){
                        curr=curr.one;
                    }else{
                        Node nn=new Node();
                        curr.one=nn;
                        curr=nn;
                    }
                }
            }
        }
        public int getMaxOr(int x){
            int ans=0;
            Node curr=root;
            for(int i=31;i>=0;i--){
                int bit=x&(1<<i);
                if(bit==0){
                    if(curr.one!=null){
                        ans=ans|(1<<i);
                        curr=curr.one;
                    }
                    else{
                        curr=curr.zero;
                    }
                }
                else{
                    if(curr.zero!=null){
                        ans=ans|(1<<i);
                        curr=curr.zero;
                    }
                    else{
                        curr=curr.one;
                    }
                }
            }
            return ans;
        }

    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int[][] qu=new int[queries.length][3];
       // int k=0;
         for (int i = 0; i < queries.length; i++) {
            qu[i][0] = queries[i][0]; // x
            qu[i][1] = queries[i][1]; // m
            qu[i][2] = i;             // original index
        }
        Arrays.sort(qu,(a,b)->a[1]-b[1]);
        int[] res=new int[queries.length];
        int k=0;
        BinaryTrie bt =new BinaryTrie();
        for(int[] arr:qu){
          //  int ans=-1;
            while(k<nums.length && nums[k]<=arr[1]){
               // ans=Math.max(ans,bt.getMaxOr(nums[k]));
                bt.add(nums[k]);
                k++;
            }
            if(k==0){
                res[arr[2]]=-1;
            }
            else{
                res[arr[2]]=bt.getMaxOr(arr[0]);
            }
            //res[arr[2]]=ans;
        }
        return res;
    }
}