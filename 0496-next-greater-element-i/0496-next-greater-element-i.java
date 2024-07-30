class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        Stack<Integer> st = new Stack<>();
        int greater[] = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }
            if(st.isEmpty()){
                greater[i]=-1;
                st.push(nums2[i]);
            }else{
                greater[i]=st.peek();
                st.push(nums2[i]);
            }
        }
        int ans[] = new int[m];
        for(int i=0; i<m; i++){
         for(int j=0; j<n; j++){
            if(nums1[i]==nums2[j]){
                ans[i]=greater[j];
            }
         }
        }
        return ans;
    }
}