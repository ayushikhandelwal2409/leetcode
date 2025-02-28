class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int i=0;
        int j=people.length-1;
        Arrays.sort(people);
        int k=0;
        while(i<=j){
            if(people[i]+people[j]<=limit){
                i++;
            }
            j--;
            k++;
        }
        return k;
    }
}