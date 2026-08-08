class Solution {
    int dx[] = {-1,0,1,0} ;
    int dy[] = {0,1,0,-1} ;
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length, m = maze[0].length ;
        if(n == 1 && m == 1) return -1 ;
        Queue<int[]> q = new LinkedList<>() ;
        maze[entrance[0]][entrance[1]] = '+' ;
        for(int move = 0 ; move < 4 ; move++){
            int i = entrance[0] + dx[move], j = entrance[1] + dy[move] ;
            if(i < 0 || j < 0 || i >= n || j >= m || maze[i][j] == '+') continue ;
            maze[i][j] = '+' ;
            q.offer(new int[]{i,j}) ;
        }
        int ans = 1 ;
        while(!q.isEmpty()){
            int size = q.size() ;
            for(int k = 0 ; k < size ; k++){
                int temp[] = q.poll() ;
                int i = temp[0], j = temp[1] ;
                for(int move = 0 ; move < 4 ; move++){
                    int ni = i + dx[move], nj = j + dy[move] ;
                    if(ni < 0 || nj < 0 || ni >= n || nj >= m) return ans ;
                    if(maze[ni][nj] == '+') continue ;
                    maze[ni][nj] = '+' ;
                    q.offer(new int[]{ni,nj}) ;
                }
            }
            ans++ ;
        }
        return -1 ;
    }
}