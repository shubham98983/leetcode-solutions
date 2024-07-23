class Solution {
    public static int findmax(int[] piles){
        int max=Integer.MIN_VALUE;
        for(int i=0; i<piles.length; i++){
            if(piles[i]>max){
                max=piles[i];
            }
        }
        return max;
    }
    public static int hours(int[] piles, int mid){
        int totalhrs=0;
        for(int i=0; i<piles.length; i++){
            // int hrs=piles[i]/mid;
            // if(piles[i]%mid!=0){
            //     hrs=hrs+1;
            // }
            // totalhrs=totalhrs+hrs;
            totalhrs+= Math.ceil((double)(piles[i]) / (double)(mid));
        }
        return totalhrs;
    }
    public int minEatingSpeed(int[] piles, int h) {
       int max=findmax(piles);
       int n =piles.length;
       int low=1;
       int high=max;
       int ans=0;
       while(low<=high){
       int mid=low+(high-low)/2;
         int totalhr = hours(piles,mid);
        if(totalhr<=h){
           high=mid-1;
        }else{
            low=mid+1;
        }
       }
       return low;
    }
}