class Solution {
    public String reverseWords(String s) {
        String[] arr=s.trim().split("\s+");
        //System.out.println(Arrays.toString(arr));
        int i=0;
        int j=arr.length-1;
         while(i<j){
            String temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        String s1="";
        for(int k=0;k<arr.length;k++){
            if(k==arr.length-1) s1+=arr[k];
            else s1+=arr[k]+" ";

        }
        return s1;
    }
}