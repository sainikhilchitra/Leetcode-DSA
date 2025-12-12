class Pair{
    int row, col, data ;
    Pair(int row, int col, int data){
        this.row = row ;
        this.col = col ;
        this.data = data ;
    }
}
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length ;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.data-b.data) ;

        for(int i=0;i<n;i++){
            pq.offer(new Pair(i,0,matrix[i][0])) ;
        }

        int eleCnt = 0 ;
        Pair p = null ;
        while(!pq.isEmpty()){
            p = pq.poll() ;
            eleCnt++ ;
            if(eleCnt == k) break ;
            if(p.col+1 < n){
                p.col++ ;
                p.data = matrix[p.row][p.col] ;
                pq.offer(p) ;
            }
        }
        return p.data ;
    }
}