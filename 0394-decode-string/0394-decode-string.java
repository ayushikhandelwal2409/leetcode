class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString=new StringBuilder();
        int k=0;
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                k = k * 10 + (ch - '0');
            }
            else if(ch=='['){
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            }
            else if(ch==']'){
                StringBuilder decodedString = stringStack.pop();
                int repeatCount = countStack.pop();
                // Repeat the current string and append it to the last string
                for (int i = 0; i < repeatCount; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString; 
            }
            else{
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }
}