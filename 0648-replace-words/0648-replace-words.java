class Solution {
    public class Trie{
        class Node{
            char ch;
            HashMap<Character,Node> child;
            boolean isTerminal;
            public Node(char ch){
                this.ch=ch;
                child=new HashMap<>();
            }
        }
        private Node root;
        public Trie(){
            root=new Node('*');
        }
        public void insert(String word){
            Node curr=root;
            for (int i = 0; i < word.length(); i++) {
                char ch=word.charAt(i);
                if(curr.child.containsKey(ch)){
                    curr=curr.child.get(ch);
                }
                else{
                    Node nn=new Node(ch);
                    curr.child.put(ch,nn);
                    curr=nn;

                }
            }
            curr.isTerminal=true;
        }
        public String searchRoot(String word){
            Node curr=root;
           StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char ch=word.charAt(i);
                if(!curr.child.containsKey(ch)){
                    return word;
                }
                prefix.append(ch);
                curr = curr.child.get(ch);

                if (curr.isTerminal) {
                    return prefix.toString();  // Found shortest root
                }
            }
            return word;
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] arr=sentence.split(" ");
        Trie t=new Trie();
        for(String s:dictionary){
            t.insert(s);
        }

        StringBuilder ans = new StringBuilder();
         for (String word : arr) {
            ans.append(t.searchRoot(word)).append(" ");
        }

        return ans.toString().trim();
    }
}