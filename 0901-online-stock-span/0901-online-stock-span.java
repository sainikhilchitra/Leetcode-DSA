class Pair{
    int day ;
    int ele ;
    Pair(int day,int ele){
        this.day = day ;
        this.ele = ele ;
    }
}
class StockSpanner {
    Stack<Pair> stk ;
    int day ;
    public StockSpanner() {
        this.day = -1 ;
        this.stk = new Stack<>() ;
        stk.push(new Pair(day,Integer.MAX_VALUE)) ;
    }
    
    public int next(int price) {
        Pair p = stk.peek() ;
        while(!stk.isEmpty() && p.ele <= price){
            stk.pop() ;
            p = stk.peek() ;
        }
        int prevDay = p.day ;
        stk.push(new Pair(++day,price)) ;
        return day - prevDay ;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */