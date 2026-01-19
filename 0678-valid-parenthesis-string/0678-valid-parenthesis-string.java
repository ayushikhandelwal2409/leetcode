class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();
		Stack<Integer> star=new Stack<>();
        Stack<Integer> open=new Stack<>();
		for(int i=0;i<n;i++){
			char ch=s.charAt(i);
			if(ch=='(') open.push(i);
			else if(ch=='*'){
                star.push(i);
            }
			else{
				if(!open.isEmpty()){
                    open.pop();
				}else if(!star.isEmpty()){
					star.pop();
				}
                else{
                    return false;
                }
			}
		}
        while(!star.isEmpty()&& !open.isEmpty()){
            if(star.pop()<open.pop()){
                return false;
            }
        }
        return open.isEmpty() ;
    }
}