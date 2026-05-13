class Solution {
    boolean search(char board[][],boolean visited[][],int i,int j,int n,int m,String word,int idx){
        
        if(idx == word.length()) return true ;
        if(i < 0 || j < 0 || i >= n || j >= m || idx >= word.length() || visited[i][j] || board[i][j] != word.charAt(idx)){
            return false ;
        }

        visited[i][j] = true ;

        int dx[] = {-1,0,1,0} ;
        int dy[] = {0,1,0,-1} ;

        for(int steps = 0 ; steps < 4 ; steps++){
            if(search(board,visited,i + dx[steps],j + dy[steps],n,m,word,idx + 1)) return true ;
        }

        visited[i][j] = false ;
        return false ;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length ;
        int m = board[0].length ;

        boolean visited[][] = new boolean[n][m] ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(search(board,visited,i,j,n,m,word,0)) return true ;
            }
        }
        return false ;
    }
}