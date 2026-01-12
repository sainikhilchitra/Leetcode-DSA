class Pair{
    int row ;
    int col ;
    Pair(int row,int col){
        this.row = row ;
        this.col = col ;
    }
}
class Solution {
    
    // BFS (all the oranges rotten the adjacent at the same time)
    int bfs(int grid[][],int n,int m){

        Queue<Pair> q = new LinkedList<>() ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 2){
                    q.offer(new Pair(i,j)) ;
                }
            }
        }

        int dx[] = {-1,0,1,0} ;
        int dy[] = {0,1,0,-1} ;
        int level = 0 ; // level indicates time
        while(!q.isEmpty()){
            int size = q.size() ;
            boolean any = false ;
            for(int i = 0 ; i < size ; i++){
                Pair p = q.poll() ;

               for(int j = 0 ; j < 4 ; j++){
                    int x = p.row + dx[j] ;
                    int y = p.col + dy[j] ;

                    if(x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1){
                        grid[x][y] = 2 ;
                        q.offer(new Pair(x,y)) ;
                        any = true ;
                    }
               }
            }
            if(any){
                level++ ;
            }
        }
        return level ;
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length ;
        int m = grid[0].length ;
        int ans = bfs(grid,n,m) ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    return -1 ;
                }
            }
        }
        return ans ;
    }
}