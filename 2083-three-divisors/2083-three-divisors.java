class Solution {
    public boolean isThree(int n) {
           int count=0;
        for(int i=1; i<=Math.sqrt(n); i++){
              if(n%i==0){
                if(n/i!=i){
                    count+=2;
                }else{
                    count++;
                }
              }
        }
        if(count==3) return true;
        return false;
    }
}