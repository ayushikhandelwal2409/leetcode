class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list=new ArrayList<>();
        pt(n,0,0,"",list);
        return list;
        
    }
    public static void pt(int n,int closed,int open,String ans,List<String> l){
        if(closed==n && open==n){
            l.add(ans);
            return;
        }
        if(closed>open || open>n ){
            return ;
        }
        pt(n,closed,open+1,ans+"(",l);
        pt(n,closed+1,open,ans+")",l);
    }
}