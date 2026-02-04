class Trie {

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
    public boolean search(String word){
        Node curr=root;
        for (int i = 0; i < word.length(); i++) {
            char ch=word.charAt(i);
            if(!curr.child.containsKey(ch)){
                return false;
            }else{
                curr=curr.child.get(ch);
            }
        }
        return curr.isTerminal;
    }
    public boolean startsWith(String prefix){
        Node curr=root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch=prefix.charAt(i);
            if(!curr.child.containsKey(ch)){
                return false;
            }else{
                curr=curr.child.get(ch);
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */