class Pair{
    int ele,cnt ;
    Pair(int ele){
        this.ele = ele ;
        this.cnt = 1 ;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Pair> hm = new HashMap<>() ;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.cnt-a.cnt) ;
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                Pair p = hm.get(nums[i]) ;
                pq.remove(p) ;
                p.cnt++ ;
                pq.offer(p) ;
            }
            else{
                Pair p = new Pair(nums[i]) ;
                hm.put(nums[i],p) ;
                pq.offer(p) ;
            }
        }

        int res[] = new int[k] ;
        for(int i=0;i<k;i++){
            res[i] = pq.poll().ele ;
        }
        return res ;
    }
}