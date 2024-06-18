class Solution {
    public static void dfs(ArrayList<ArrayList<Integer>> graph,int curr, boolean vis[]){
        vis[curr]=true;
        for(int i=0; i<graph.get(curr).size(); i++){
            Integer e = graph.get(curr).get(i);
            if(!vis[e]){
                dfs(graph,e,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int count =0;
     int n = isConnected.length;
     ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    for(int i=0; i<n; i++){
        graph.add(new ArrayList<>());
    }
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(isConnected[i][j]==1 && i!=j){
                graph.get(i).add(j);
                graph.get(j).add(i);
            }
        }
    }
     boolean vis[] = new boolean[n];
    for(int i=0; i<n; i++){
        if(vis[i]==false){
            dfs(graph,i,vis);
            count++;
        }
    }
        return count;
    }
}