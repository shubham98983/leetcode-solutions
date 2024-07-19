class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int number = x;
        int reverse = 0;
        while(x!=0){
            int last = x%10;
            reverse = (reverse*10)+last;
            x=x/10;
        }
        if(reverse==number){
            return true;
        }
        return false;
    }
}