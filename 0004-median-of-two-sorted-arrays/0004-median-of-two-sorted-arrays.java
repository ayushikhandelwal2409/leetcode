class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int k=nums1.length;
        int m=nums2.length;
        int n=m+k;
        int i=0;
        int j=0;
        int ind2=n/2;
        int ind1=ind2-1;
        int ind1el=-1;
        int ind2el=-1;
        int cnt=0;
        while(i<k && j<m){
            if(nums1[i]<nums2[j]){
                if(cnt==ind1) ind1el=nums1[i];
                if(cnt==ind2) ind2el=nums1[i];
                cnt++;
                i++;
            }
            else {
                if(cnt==ind1) ind1el=nums2[j];
                if(cnt==ind2) ind2el=nums2[j];
                cnt++;
                j++;
            }
        }
        while(i<k){
            if(cnt==ind1) ind1el=nums1[i];
            if(cnt==ind2) ind2el=nums1[i];
            cnt++;
            i++;
        }
        while(j<m){
            if(cnt==ind1) ind1el=nums2[j];
            if(cnt==ind2) ind2el=nums2[j];
            cnt++;
            j++;
        }
        if(n%2==0)
            return Double.valueOf(ind1el+ind2el)/2.0;
        else
            return ind2el;
    }
}