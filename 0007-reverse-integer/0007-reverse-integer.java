class Solution {
    public int reverse(int x) {
        long reverse=0;
        int number=x;
        while(x!=0){
            int last = x%10;
             reverse = (reverse*10)+last;
            x=x/10;
        }
   if(reverse>Integer.MIN_VALUE && reverse<Integer.MAX_VALUE){
       reverse = (int)reverse;
   }else{
    reverse=0;
   }
        return (int)reverse;
    }
}