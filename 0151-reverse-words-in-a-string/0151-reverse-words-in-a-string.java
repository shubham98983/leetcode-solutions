class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String[] a = s.split("\\s+");
        String ans="";
        for(int i=a.length-1; i>=0; i--){
          ans=ans+a[i];
          ans=ans+" ";
        }
        int n = ans.length();
        ans=ans.substring(0,n-1);
        return ans;
    }
}