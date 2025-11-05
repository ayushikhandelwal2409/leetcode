//tle
// class Solution {
//     public long[] findXSum(int[] nums, int k, int x) {
//         int n=nums.length;
//         long[] ans=new long[n-k+1];
//         for(int i=0;i<=n-k;i++){
//             HashMap<Integer,Integer> map=new HashMap<>();
//             for(int j=i;j<i+k;j++){
//                 map.put(nums[j],map.getOrDefault(nums[j],0)+1);
//             }
//             long c=0;
//             ArrayList<int[]> l=new ArrayList<>();
//             for(Map.Entry<Integer,Integer> entry:map.entrySet()){
//                 l.add(new int[]{entry.getValue(),entry.getKey()});
//             }
//             l.sort((a,b)->b[0]!=a[0]?b[0]-a[0]:b[1]-a[1]);
//             for(int j=0;j<x && j<l.size();j++){
//                 c+=(long)l.get(j)[0]*l.get(j)[1];
//             }
//             ans[i]=c;
//         }
//         return ans;
//     }
// }


// class Solution {
//     public long[] findXSum(int[] nums, int k, int x) {
//         int n=nums.length;
//         long[] ans=new long[n-k+1];
//         HashMap<Integer,Integer> map=new HashMap<>();
//         for(int i=0;i<k;i++){
//             map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//         }
//         ans[0]=getmaxsum(map,x);
//         for(int i=k;i<n;i++){
//             int out=nums[i-k];
//             map.put(out,map.get(out)-1);
//             if(map.get(out)==0){
//                 map.remove(out);
//             }
//             int in=nums[i];
//             map.put(in,map.getOrDefault(in,0)+1);
//             ans[i-k+1]=getmaxsum(map,x);
//         }
//         return ans;
//     }
//     public long getmaxsum(HashMap<Integer,Integer> map,int x){
//         long c=0;
//         ArrayList<int[]> l=new ArrayList<>();
//         for(Map.Entry<Integer,Integer> entry:map.entrySet()){
//             l.add(new int[]{entry.getValue(),entry.getKey()});
//         }
//         l.sort((a,b)->b[0]!=a[0]?b[0]-a[0]:b[1]-a[1]);
//         for(int j=0;j<x && j<l.size();j++){
//             c+=(long)l.get(j)[0]*l.get(j)[1];
//         }
//         return c;
//     }
// }
class Solution {

    public int compare(int[] a,int[] b){
        if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
        return Integer.compare(a[1],b[1]);
    }

    public void insertInSet(TreeSet<int[]> main,TreeSet<int[]> sec,int[] p,int x,long[] sum){
        if (main.size()<x || compare(p,main.first()) > 0) {
            main.add(p);
            sum[0] += 1L * p[0] * p[1];
            if (main.size()>x) {
                int[] smallest = main.pollFirst();
                sum[0] -= 1L * smallest[0] * smallest[1];
                sec.add(smallest);
            }
        } else sec.add(p);
    }

    public void removeFromSet(TreeSet<int[]> main,TreeSet<int[]> sec,int[] p,int x,long[] sum){
        if (main.remove(p)) {
            sum[0] -= 1L * p[0] * p[1];
            if (!sec.isEmpty()) {
                int[] largest = sec.pollLast();
                main.add(largest);
                sum[0] += 1L * largest[0] * largest[1];
            }
        } else sec.remove(p);
    }

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] sum = new long[1];

        HashMap<Integer,Integer> map = new HashMap<>();

        Comparator<int[]>  comp = (a,b)->{// pair -> (freq,ele);
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);// diff freq
            return Integer.compare(a[1],b[1]);// same freq so compare ele
        };

        TreeSet<int[]> main = new TreeSet<>(comp);
        TreeSet<int[]> sec = new TreeSet<>(comp);

        long[] ans = new long[n-k+1];
        int i=0;
        int j=0;

        while(j<n){
            int num = nums[j];
            int oldFreq = map.getOrDefault(num,0);

            if(oldFreq>0){// If already present,remove old (freq,val)
                removeFromSet(main,sec,new int[]{oldFreq,num},x,sum);
            }
            
            map.put(num,oldFreq+1);// new freq

            insertInSet(main,sec,new int[]{oldFreq+1,num},x,sum);// Insert updated pair

            if(j-i+1==k){// if window size becomes k
                ans[i] = sum[0];

                // i will move (Window shrink mf)
                int outNum = nums[i];
                int outFreq = map.get(outNum);
                removeFromSet(main,sec,new int[]{outFreq,outNum},x,sum);

                if (outFreq == 1) map.remove(outNum);

                else {
                    map.put(outNum,outFreq - 1);
                    insertInSet(main,sec,new int[]{outFreq-1,outNum},x,sum);
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}