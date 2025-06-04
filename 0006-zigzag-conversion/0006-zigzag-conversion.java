class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || numRows >= s.length()) {
            return s;
        }
        ArrayList<ArrayList<Character>> list=new ArrayList<>();
        int k=0;
        for(int i=0;i<numRows;i++){
            list.add(new ArrayList<>());
        }
        char[] arr=s.toCharArray();
        boolean check=false;
        for(int i=0;i<arr.length;i++){
            char ch=arr[i];
            list.get(k).add(ch);
            if(k==numRows-1){
                check=false;
            }else if(k==0){
                check=true;
            }
            k+=check? 1:-1;
        }
        StringBuilder result = new StringBuilder();
        for (int i=0;i<list.size();i++) {
            for (Character c : list.get(i)){
                result.append(c);
            }
        }
        return result.toString();
    }
}