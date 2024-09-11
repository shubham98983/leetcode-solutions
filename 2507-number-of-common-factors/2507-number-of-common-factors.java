class Solution {
    public int commonFactors(int a, int b) {
        int n = Math.min(a,b);
        int count=0;
        for(int i=n; i>=1; i--){
            if(a%i==0 && b%i==0){
                count++;
            }
        }
        return count;
    }
}