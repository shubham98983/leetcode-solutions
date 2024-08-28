class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>ans = new ArrayList<>();
        int num[] = new int[9];
        for(int i=1; i<=9; i++){
            num[i-1]=i;  
        } 
        findcombinations(0, num , k ,n,ans,new ArrayList<>());
        return ans;
    }
    public void findcombinations(int idx,int[] num,int pair, int sum,List<List<Integer>> ans ,List<Integer> ds){
        if(idx==num.length){
            if(sum==0 && pair==0){
                ans.add(new ArrayList(ds));
            }
            return;
        }
        if(num[idx]<=sum & pair>0){
         ds.add(num[idx]);
         findcombinations(idx+1,num,pair-1,sum-num[idx],ans,ds);
         ds.remove(ds.size()-1);
        }
        findcombinations(idx+1,num,pair,sum,ans,ds);
    }
}