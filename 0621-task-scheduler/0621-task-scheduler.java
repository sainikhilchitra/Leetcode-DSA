// class Pair{
//     int val ;
//     int time ;
//     Pair(int val,int time){
//         this.val = val ;
//         this.time = time ;
//     }
// }
class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        // suppose maxFreq = 3 ,n = 2  A _ _ A _ _ A  idle = (maxFreq - 1) * n time
        // so next time the idles are filled by other tasks
        int count[] = new int[26] ;

        for(int i = 0 ; i < tasks.length ; i++){
            count[tasks[i] - 'A']++ ;
        }
        Arrays.sort(count) ;

        int maxFreq = count[25] ;
        int idle = n * (maxFreq - 1) ;

        for(int i = 24 ; i >= 0 ; i--){
            idle -= Math.min(maxFreq - 1,count[i]) ;
        }

        idle = Math.max(0,idle) ;

        return tasks.length + idle ;
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b - a) ;

        // Queue<Pair> q = new LinkedList<>() ;

        // int count[] = new int[26] ;

        // for(int i = 0 ; i < tasks.length ; i++){
        //     count[tasks[i] - 'A']++ ;
        // }

        // for(int i = 0 ; i < 26 ; i++){
        //     if(count[i] > 0){
        //         pq.offer(count[i]) ;
        //     }
        // }

        // int t = 0 ;
        // while(!pq.isEmpty() || !q.isEmpty()){
        //     while(!q.isEmpty() && q.peek().time + 1 == t){
        //         pq.offer(q.poll().val) ;
        //     }
        //     if(!pq.isEmpty()){
        //         int taskFreq = pq.poll() ;
        //         if(taskFreq > 1){
        //             q.offer(new Pair(taskFreq - 1,t + n)) ;
        //         }
        //     }
        //     t++ ;
        // }
        // return t ;
    }
}