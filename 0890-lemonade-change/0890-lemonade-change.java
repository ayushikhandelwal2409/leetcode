class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int ten=0;
        int twenty=0;
        for(int cost:bills){
            if(cost==5){ 
                five++;
            }
            else if(cost==10){ 
                if (five == 0) return false;
                five--;
                ten++;
            }
            else{
                twenty++;
                if(five>0 && ten>0){
                    five--;
                    ten--;
                }
                else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return  true;
    }
}