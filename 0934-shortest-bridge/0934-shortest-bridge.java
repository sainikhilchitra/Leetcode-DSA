class Solution {
    int dx[] = {-1,0,1,0} ;
    int dy[] = {0,1,0,-1} ;
    void dfs(int grid[][],int i,int j,int n,int m){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != 1) return ;
        grid[i][j] = 2 ;
        for(int move = 0 ; move < 4 ; move++){
            dfs(grid,i + dx[move],j + dy[move],n,m) ;
        }
    }
    public int shortestBridge(int[][] grid) {
        int n = grid.length, m = grid[0].length ;
        for(int i = 0 ; i < n ; i++){
            boolean found = false ;
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    found = true ;
                    dfs(grid,i,j,n,m) ;
                    break ;
                }
            }
            if(found) break ;
        }

        Queue<int[]> q = new LinkedList<>() ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    q.offer(new int[]{i,j}) ;
                }
                System.out.print(grid[i][j]+" ") ;
            }
            System.out.println() ;
        }
        int ans = 0 ;
        while(!q.isEmpty()){
            int size = q.size() ;
            for(int k = 0 ; k < size ; k++){
                int temp[] = q.poll() ;
                int i = temp[0], j = temp[1] ;
                for(int move = 0 ; move < 4 ; move++){
                    int ni = i + dx[move], nj = j + dy[move] ;
                    if(ni < 0 || nj < 0 || ni >= n || nj >= m || grid[ni][nj] == 1) continue ;
                    if(grid[ni][nj] == 2) return ans ;
                    grid[ni][nj] = 1 ;
                    q.offer(new int[]{ni,nj}) ;
                }
            }
            ans++ ;
        }
        return ans ;
    }
}