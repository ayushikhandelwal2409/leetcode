class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        for(String s:wordList){
            set.add(s);
        }
        Queue<String[]> q=new LinkedList<>();
        q.add(new String[]{beginWord,"1"});
        set.remove(beginWord);
        while(!q.isEmpty()){
            String[] str=q.poll();
            String word=str[0];
            
            int steps=Integer.valueOf(str[1]);
            if(word.equals(endWord)) return steps;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] arr=word.toCharArray();
                    arr[i]=ch;
                    String replacedWord=new  String(arr);
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        System.out.println(word);
                        int k=steps+1;
                        q.offer(new String[]{replacedWord,String.valueOf(k)});

                    }
                }
            }
        }
        return 0;
    }
}