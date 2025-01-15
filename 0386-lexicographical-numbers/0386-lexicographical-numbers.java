class Solution {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> list=new ArrayList<>();
        lo(n,0,list);
        return list;
    }
    public static void lo(int n,int curr,List<Integer> l){
        if(curr>n) return;
        if(curr!=0) l.add(curr);
        int i=0;
        if(curr==0){
            i=1;
        }
        for(;i<=9;i++){
            lo(n,curr*10+i,l);
        }
    }
}