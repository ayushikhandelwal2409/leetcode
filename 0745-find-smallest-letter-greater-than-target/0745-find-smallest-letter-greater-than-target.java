class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int s=0;
        int e=letters.length-1;
        char ch=letters[0];
        while(s<=e){
            int mid=(s+e)/2;
            if(letters[mid]<=target) {
                s=mid+1;
                
            }
            else{
                e=mid-1;
                ch=letters[mid];
            }
        }
        return ch;
    }
}