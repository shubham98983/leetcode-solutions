class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea=0;
        for(int i=0; i<n; i++){
            while(!st.isEmpty()&&heights[st.peek()]>heights[i]){
               int idx=st.pop();
               int nse =i;
               int pse=st.isEmpty() ? -1:st.peek();
               maxArea=Math.max(heights[idx]*(nse-pse-1),maxArea);
            }
             st.push(i);
        }
            while(!st.isEmpty()){
                int nse=n;
                int idx=st.pop();
                int pse=st.isEmpty() ? -1:st.peek();
                maxArea=Math.max(heights[idx]*(nse-pse-1),maxArea);
            }
        return maxArea;
    }
}