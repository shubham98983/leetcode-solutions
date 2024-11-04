class Solution {
    public static void dfs(int node,boolean[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[node]=true;
        for(int it:adj.get(node)){
            if(!vis[it]){
                dfs(it,vis,adj);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int count=0;
        int v = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<v; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
              if(isConnected[i][j]==1 && i!=j){
                 adj.get(i).add(j);
                 adj.get(j).add(i);
              }
            }
        }
        boolean vis[] = new boolean[v];
        for(int i=0; i<v; i++){
            if(!vis[i]){
                count++;
                dfs(i,vis,adj);
            }
        }
        return count;
    }
}