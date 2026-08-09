class Solution {
    boolean check(int mat[][],int gap){
        if(mat[0][0] < gap) return false ;
        int n = mat.length ;
        boolean visited[][] = new boolean[n][n] ;
        Queue<int[]> q = new LinkedList<>() ;
        q.offer(new int[]{0,0}) ;
        visited[0][0] = true ;
        while(!q.isEmpty()){
            int temp[] = q.poll() ;
            int i = temp[0], j = temp[1] ;
            if(i == n - 1 && j == n - 1) return true ;
            for(int move = 0 ; move < 4 ; move++){
                int ni = i + dx[move], nj = j + dy[move] ;
                if(ni < 0 || nj < 0 || ni >= n || nj >= n || visited[ni][nj] || mat[ni][nj] < gap) continue ;
                visited[ni][nj] = true ;
                q.offer(new int[]{ni,nj}) ;
            }
        }
        return false ;
    }
    int dx[] = {-1,0,1,0} ;
    int dy[] = {0,1,0,-1} ;
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size() ;
        int mat[][] = new int[n][n] ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                mat[i][j] = grid.get(i).get(j) ;
            }
        }
        Queue<int[]> q = new LinkedList<>() ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j] == 1){
                    q.offer(new int[]{i,j}) ;
                    mat[i][j] = 2 ;
                }
            }
        }
        int dp[][] = new int[n][n] ;
        int count = 0 ;
        while(!q.isEmpty()){
            int size = q.size() ;
            for(int k = 0 ; k < size ; k++){
                int temp[] = q.poll() ;
                int i = temp[0], j = temp[1] ;
                dp[i][j] = count ;
                for(int move = 0 ; move < 4 ; move++){
                    int ni = i + dx[move], nj = j + dy[move] ;
                    if(ni < 0 || nj < 0 || ni >= n || nj >= n || mat[ni][nj] == 2) continue ;
                    mat[ni][nj] = 2 ;
                    q.offer(new int[]{ni,nj}) ;
                }
            }
            count++ ;
        }

        int ans = 0 ;
        int low = 0, high = count - 1 ;
        while(low <= high){
            int mid = (low + high) / 2 ;
            if(check(dp,mid)){
                ans = mid ;
                low = mid + 1 ;
            }
            else{
                high = mid - 1 ;
            }
        }
        return ans ;
    }
}