class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int x =0;
        int y =0;
        int count=0;
        while(x<players.length && y<trainers.length){
            if(trainers[y]>=players[x]){
                y++;
                x++;
                count++;
            }else{
                y++;
            }
        }
        return count;
    }
}