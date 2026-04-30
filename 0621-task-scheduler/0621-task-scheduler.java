class Pair{
    int val ;
    int time ;
    Pair(int val,int time){
        this.val = val ;
        this.time = time ;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b) ;

        Queue<Pair> q = new LinkedList<>() ;

        int count[] = new int[26] ;

        for(int i = 0 ; i < tasks.length ; i++){
            count[tasks[i] - 'A']++ ;
        }

        for(int i = 0 ; i < 26 ; i++){
            if(count[i] > 0){
                pq.offer(count[i]) ;
            }
        }

        int t = 0 ;
        while(!pq.isEmpty() || !q.isEmpty()){
            while(!q.isEmpty() && q.peek().time == t - 1){
                pq.offer(q.poll().val) ;
            }
            if(!pq.isEmpty()){
                int taskFreq = pq.poll() ;
                if(taskFreq > 1){
                    q.offer(new Pair(taskFreq - 1,t + n)) ;
                }
            }
            t++ ;
        }
        return t ;
    }
}