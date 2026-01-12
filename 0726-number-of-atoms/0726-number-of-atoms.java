class Solution {
    public String countOfAtoms(String formula) {
        int n=formula.length();
        Stack<Map<String,Integer>> st=new Stack<>();
        st.push(new HashMap<>());
        for(int i=0;i<n;){
            char ch=formula.charAt(i);
            if(ch=='('){
                st.push(new HashMap<>());
                i++;
            }
            else if(ch==')'){
                i++;
                int multiplier=0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    multiplier = multiplier * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                if (multiplier == 0) multiplier = 1;
                Map<String, Integer> top = st.pop();
                Map<String, Integer> curr = st.peek();

                for (String atom : top.keySet()) {
                    curr.put(atom, curr.getOrDefault(atom, 0) + top.get(atom) * multiplier);
                }
            }
            else{
                
                StringBuilder s=new StringBuilder();
                s.append(ch);
                i++;
                while(i<n && Character.isLowerCase(formula.charAt(i))){
                    s.append(formula.charAt(i));
                    i++;
                }
                int val=0;
                while(i<n && Character.isDigit(formula.charAt(i))){
                    val=val*10+(formula.charAt(i)-'0');
                    i++;
                }
                if(val==0) val=1;
                Map<String, Integer> curr = st.peek();
                curr.put(s.toString(), curr.getOrDefault(s.toString(), 0) + val);
            }
        }
        Map<String, Integer> result = st.pop();
        TreeMap<String,Integer> tree=new TreeMap<>(result);
        StringBuilder sb=new StringBuilder();
        for(String key:tree.keySet()){
            sb.append(key);
            if(tree.get(key)>1){
                sb.append(tree.get(key));
            }
        }
        return sb.toString();
    }
}