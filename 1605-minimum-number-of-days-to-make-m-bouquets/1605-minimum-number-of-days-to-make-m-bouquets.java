class Solution {
    public static boolean possible(int[] bloomDay,int mid,int m,int k){
        int n=bloomDay.length;
        int count=0;
        int num=0;
        for(int i=0; i<n; i++){
            if(bloomDay[i]<=mid){
                count++;
            }else{
                num+=count/k;
                count=0;
            }
        }
        num+=count/k;
        return num>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        long val = (long)m*k;
        int n = bloomDay.length;
        if(val>n) return -1;
          int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }
        int low=mini;
        int high=maxi;
        while(low<=high){
            int mid=(low+high)/2;
            if(possible(bloomDay,mid,m,k)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}