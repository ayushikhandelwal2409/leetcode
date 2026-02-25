class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character,Integer> map=new HashMap<>();//frequency map  represents how many occurrences are left in the future part of the string.
        char[] arr=s.toCharArray();
        for(char ch:arr){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        Stack<Integer> st=new Stack<>();
        boolean[] seen = new boolean[26]; // keep track seen
        String ans="";
        for(char ch:arr){
            int curr = ch - 'a';
            map.put(ch, map.get(ch) - 1);
            if (seen[curr]) continue;
            while(!st.isEmpty() && st.peek()>curr && map.get((char)(st.peek()+'a'))>0){
                seen[st.pop()] = false;
            }
            st.push(curr);
            seen[curr]=true;
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty())
            sb.append((char) (st.pop() + 'a'));
        return sb.reverse().toString();
    }
}