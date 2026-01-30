class Pair{
    int i ;
    int j ;

    Pair(int i, int j){
        this.i = i ;
        this.j = j ;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length ;
        int m = grid[0].length ;
        if(grid[0][0] == 1 || grid[n - 1][m - 1] == 1) return -1 ;

        if(n == 1 && m == 1) return 1 ;
        
        Queue<Pair> q = new LinkedList<>() ;
        q.offer(new Pair(0,0)) ;

        int steps = 1 ;
        while(!q.isEmpty()){
            int size = q.size() ;

            steps++ ;
            while(size-- > 0){
                Pair p = q.poll() ;

                for(int i = -1 ; i <= 1 ; i++){
                    for(int j = -1 ; j <= 1 ; j++){
                        if(i == 0 && j == 0) continue ;
                        int row = p.i + i ;
                        int col = p.j + j ;

                        if(row < 0 || col < 0 || row >= n || col >= m || grid[row][col] == 1) continue ;
                        if(row == n - 1 && col == m - 1) return steps ;

                        grid[row][col] = 1 ;
                        q.offer(new Pair(row,col)) ;
                    }
                }
            }
        }

        return -1 ;
    }
}