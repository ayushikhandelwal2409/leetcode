class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        ArrayList<ArrayList<Integer>> sums=new ArrayList<>();
        String ans="";
        int no_of_zeroes=0;
        for(int i=num2.length()-1;i>=0;i--){
            sums.add(pro_of_each_num(num1,num2.charAt(i),no_of_zeroes));
            no_of_zeroes++;
        }

        StringBuilder answer = sumResults(sums);
        answer.reverse();
        return answer.toString();

    }
    public ArrayList<Integer> pro_of_each_num(String num1, char n,int no_of_zeroes ){
        ArrayList<Integer> currentResult = new ArrayList<>();
        for(int i=0;i<no_of_zeroes;i++){
            currentResult.add(0);
        }
        int carry=0;
        int mod=0;
        for(int i=num1.length()-1;i>=0;i--){
            int val=(num1.charAt(i)-'0')*( n-'0' ) + carry;
            mod=val%10;
            carry=val/10;
            currentResult.add(mod);
        }
        if (carry != 0) {
            currentResult.add(carry);
        }
        return currentResult;
    }
    public StringBuilder sumResults(ArrayList<ArrayList<Integer>> results){
        ArrayList<Integer> answer = new ArrayList<>(results.get(results.size() - 1));
        ArrayList<Integer> newAnswer = new ArrayList<>();

        for (int j = 0; j < results.size() - 1; ++j) {
            ArrayList<Integer> result = new ArrayList<>(results.get(j));
            newAnswer = new ArrayList<>();

            int carry = 0;

            for (int i = 0; i < answer.size() || i < result.size(); ++i) {

                int digit1 = i < result.size() ? result.get(i) : 0;
                int digit2 = i < answer.size() ? answer.get(i) : 0;

                int sum = digit1 + digit2 + carry;

                carry = sum / 10;

                newAnswer.add(sum % 10);
            }

            if (carry != 0) {
                newAnswer.add(carry);
            }
            answer = newAnswer;
        }

        StringBuilder finalAnswer = new StringBuilder();
        for (int digit : answer) {
            finalAnswer.append(digit);
        }
        return finalAnswer;
    }
}