class Solution {
         class Time{
         int sTime;
         int eTime;
     Time(int sTime,int eTime){
         this.sTime=sTime;
         this.eTime=eTime;
     }
     }
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
            PriorityQueue<Time> pq = new PriorityQueue<>(new Comparator<Time>() {
            @Override
            public int compare(Time t1, Time t2) {
                return t1.eTime - t2.eTime; // Sort by ascending end time
            }
        });
            for (int i = 0; i < n; i++) {
            pq.add(new Time(intervals[i][0], intervals[i][1]));
        }
          int count=0;
       int endTime =Integer.MIN_VALUE;
       while(!pq.isEmpty()){
           Time current = pq.poll();
           if(current.sTime>=endTime){
               endTime=current.eTime;
               count++;
           }
       }
       return n-count;
    }
}