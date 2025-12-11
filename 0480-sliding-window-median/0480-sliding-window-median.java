class Solution {
    PriorityQueue<Integer> left ;
    PriorityQueue<Integer> right ;
    HashMap<Integer,Integer> hm ;
    int leftSize, rightSize ;
    Solution(){
        left = new PriorityQueue<>((a,b)->b.compareTo(a)) ;
        right = new PriorityQueue<>() ;
        hm = new HashMap<>() ;
        leftSize = 0 ;
        rightSize = 0 ;
    }

    void add(int x){
        if(leftSize == 0 || left.peek() > x){
            left.offer(x) ;
            leftSize++ ;
        }
        else{
            right.offer(x) ;
            rightSize++ ;
        }
        balance() ;
    }

    void balance(){
        if(leftSize-rightSize > 1){
            right.offer(left.poll()) ;
            rightSize++ ;
            leftSize-- ;
            prune(left) ;
        }
        if(leftSize-rightSize < 0){
            left.offer(right.poll()) ;
            rightSize-- ;
            leftSize++ ;
            prune(right) ;
        }
    }

    void remove(int x){
        hm.put(x,hm.getOrDefault(x,0)+1) ;
        if(left.peek()>=x){
            leftSize-- ;
        }
        else{
            rightSize-- ;
        }
        prune(left) ;
        prune(right) ;
        balance() ;
    }

    void prune(PriorityQueue<Integer> heap){
        while(hm.containsKey(heap.peek())){
            hm.put(heap.peek(),hm.get(heap.peek()) - 1) ;
            if(hm.get(heap.peek()) == 0){
                hm.remove(heap.peek()) ;
            }
            heap.poll() ;
        }
    }

    double median(){
        if(leftSize == rightSize+1){
            return left.peek() ;
        }
        return ((long)left.peek() + (long) right.peek()) / 2.0 ;
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length ;
        double res[] = new double[n-k+1] ;

        for(int i=0;i<k;i++){
            add(nums[i]) ;
        }
        res[0] = median() ;

        for(int i=k;i<n;i++){
            add(nums[i]) ;
            remove(nums[i-k]) ;
            res[i-k+1] = median() ; 
        }

        return res ;
    }
}