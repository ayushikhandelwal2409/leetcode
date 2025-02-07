class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
                List<List<Integer>> ll= new ArrayList<>();
        List<Integer> l= new ArrayList<>();
        print(n,k,ll,1,l);
        return ll;
    }
    public static void print(int n,int k,List<List<Integer>> ll,int start,List<Integer> l){
        if(l.size()==k && n==0){
            ll.add(new ArrayList<>(l));
            return ;
        }
        for(int i=start;i<=9;i++){
            if(n>=i){
                l.add(i);
                print(n-i,k,ll,i+1,l);
                l.remove(l.size()-1);
            }
        }
    }
}