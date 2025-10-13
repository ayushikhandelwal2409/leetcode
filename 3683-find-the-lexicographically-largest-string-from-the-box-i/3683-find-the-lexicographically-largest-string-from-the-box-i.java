class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        String largest="";
        int n=word.length();
        int my_string_len=(n-numFriends)+1;
        for(int i=0;i<n;i++){
            String sub = word.substring(i,Math.min(i+my_string_len, n));
            if (sub.compareTo(largest) > 0) {
                largest = sub;
            }
        }
        return largest;
    }
}