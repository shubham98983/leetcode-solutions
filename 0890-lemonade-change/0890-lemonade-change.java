class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int x =0; // $5 change
        int y =0; // $10 change
        int i=0; // pointer
        boolean ans = true;
        if(bills[0]==10 || bills[0]==20){
            ans = false;
        }else{
        while(i<n){
            if(bills[i]==5) x++;
            if(bills[i]==10){
                if(x==0){
                    ans = false;
                    break;
                }
                else{
                    x--;
                    y++;
                }
            }
            if(bills[i]==20){
                if(x>0 && y>0){
                    x--;
                    y--;
                }else if(x>=3){
                    x = x-3;
                }else{
                   ans=false;
                   break;
                }
            }
            i++;
        }
        }
        return ans;
    }
}