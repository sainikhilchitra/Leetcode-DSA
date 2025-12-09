class MedianFinder {
    PriorityQueue<Integer> left ;
    PriorityQueue<Integer> right ;
    public MedianFinder() {
        left = new PriorityQueue<>((a,b)->b-a);
        right = new PriorityQueue<>() ;
    }
    
    public void addNum(int num) {
        if(left.size() == 0) {
            left.offer(num) ;
            return ;
        }
        if(left.peek()<num){
            right.offer(num) ;
        }
        else{
            left.offer(num) ;
        }
        int n1 = left.size() ;
        int n2 = right.size() ;
        if(n1-n2 > 1){
            right.offer(left.poll()) ;
        }
        if(n1-n2 < 0){
            left.offer(right.poll()) ;
        }
    }
    
    public double findMedian() {
        if(left.size() == right.size()){
            return (double)(left.peek()+right.peek())/2 ;
        }
        else{
            return left.peek() ;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */