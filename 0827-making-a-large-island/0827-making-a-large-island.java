class Solution {
    // Assigning unique id's for each island
    // it starts from 2 as 0,1 are already in grid and we might confuse
    ArrayList<Integer> unique = new ArrayList<>() ;
    int id = 2 ;

    int dx[] = {-1,0,1,0} ;
    int dy[] = {0,1,0,-1} ;
    int dfs(int grid[][],int i,int j,int n,int m){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != 1) return 0 ;
        grid[i][j] = id ;
        int ans = 1 ;
        for(int move = 0 ; move < 4 ; move++){
            ans += dfs(grid,i + dx[move],j + dy[move],n,m) ;
        }
        return ans ;
    }
    int help(int grid[][],int i,int j,int n,int m){
        HashSet<Integer> hs = new HashSet<>() ;
        for(int move = 0 ; move < 4 ; move++){
            int ni = i + dx[move], nj = j + dy[move] ;
            if(ni < 0 || nj < 0 || ni >= n || nj >= m) continue ;
            hs.add(grid[ni][nj]) ;
        }
        int ans = 1 ;
        for(int ele : hs){
            ans += unique.get(ele) ;
        }
        return ans ;
    }
    public int largestIsland(int[][] grid) {
        unique.add(0) ;
        unique.add(0) ;
        int n = grid.length, m = grid[0].length ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    unique.add(dfs(grid,i,j,n,m)) ;
                    if(unique.get(id) == n * m) return n * m ;
                    id++ ;
                }
            }
        }
        int ans = 1 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 0){
                    ans = Math.max(ans,help(grid,i,j,n,m)) ;
                }
            }
        }
        return ans ;
    }
}