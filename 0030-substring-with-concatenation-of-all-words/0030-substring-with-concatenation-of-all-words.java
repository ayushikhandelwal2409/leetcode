class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> ans =new ArrayList<>();
        int wordcount=words.length;
        int wordlength=words[0].length();
        int total_length=wordcount*wordlength;
        HashMap<String,Integer> map=new HashMap<>();
        for( String word:words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < wordlength; i++) {
            int left = i, right = i, count = 0;
            HashMap<String, Integer> seen = new HashMap<>();

            while (right + wordlength <= s.length()) {
                String word = s.substring(right, right + wordlength);
                right += wordlength;

                if (map.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    while (seen.get(word) > map.get(word)) {
                        String leftWord = s.substring(left, left + wordlength);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += wordlength;
                    }

                    if (count == wordcount) {
                        ans.add(left);
                    }
                } else {
                    // reset window
                    seen.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return ans;
    }
}