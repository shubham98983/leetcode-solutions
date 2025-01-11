class Solution {
    public boolean compare(String first, String second){
        if(first.length()+1 != second.length()) return false;
        int i=0;
        int j=0;
        while(j<second.length()){
            if(i<first.length() && first.charAt(i)==second.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        return i==first.length() && j==second.length();
    }
    public int longestStrChain(String[] words) {
        // Comparator<String> comp = (s1, s2) -> s1.length() - s2.length();
        int n = words.length;
        int dp[] = new int[n];
        int max=1;
        Arrays.fill(dp,1);
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for(int i=0; i<n; i++){
           for(int j=0; j<i; j++){
              if(compare(words[j],words[i])==true && 1+dp[j]>dp[i]){
                 dp[i]=1+dp[j];
              }
           }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}