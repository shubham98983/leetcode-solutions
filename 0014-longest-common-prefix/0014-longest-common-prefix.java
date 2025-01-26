class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n =strs.length;
        String ans="";
        String temp = strs[0];
        int i=0;
        while(i<temp.length()){
           char c= temp.charAt(i);
           boolean valid=true;
           for(int j=1; j<n; j++){
             if(i<strs[j].length()){
                 if(strs[j].charAt(i)!=c) valid=false;
             }else{
                 valid=false;
             }
           }
            if(valid==true) ans=ans+c;
            if(valid==false) break;
            i++;
        }
        return ans;
    }
}