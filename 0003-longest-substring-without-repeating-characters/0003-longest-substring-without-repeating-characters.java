class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int r=0;
        int l=0;
        int length=0;
        int maxLen=0;
        HashMap<Character,Integer> hm = new HashMap<>();
        while(r<n){
            if(hm.containsKey(s.charAt(r))){
                if(hm.get(s.charAt(r))>=l){
                    l=hm.get(s.charAt(r))+1;
                }
            }
         length=r-l+1;
         maxLen=Math.max(maxLen,length);
         hm.put(s.charAt(r),r);
         r++;
        }
        return maxLen;
    }
}