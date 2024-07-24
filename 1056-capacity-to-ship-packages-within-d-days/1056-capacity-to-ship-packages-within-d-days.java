class Solution {
    public static boolean possible(int[] weights,int mid, int days){
        int n=weights.length;
        int sum=0;
        int count=1;
        for(int i=0; i<n; i++){
            if(sum+weights[i]>mid){
                count++;
                sum=weights[i];
            }else{
                sum=sum+weights[i];
            }
        }
        if(count<=days){
             return true;
        }
        return false;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int max=Integer.MIN_VALUE;
        int total=0;
        int ans=0;
        for(int i=0; i<n; i++){
           total=total+weights[i];
           if(weights[i]>max){
            max=weights[i];
           }
        }
        int low=max;
        int high=total;
        while(low<=high){
            int mid=(low+high)/2;
            if(possible(weights,mid,days)==true){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}