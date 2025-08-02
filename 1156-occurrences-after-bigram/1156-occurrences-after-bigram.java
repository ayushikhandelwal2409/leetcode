class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        ArrayList<String> list=new ArrayList<>();
        String[] arr=text.split(" ");
        for(int i=0;i<arr.length-2;i++){
            if(arr[i].equals(first) && arr[i+1].equals(second)){
                list.add(arr[i+2]);
            }
        }
        String[] ans=new String[list.size()];
        int i=0;
        for(String k:list){
            ans[i]=k;
            i++;
        }
        return ans;
    }
}