class Solution {
    public boolean validTicTacToe(String[] board) {
        int x = 0, o = 0 ;
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                if(board[i].charAt(j) == 'X') x++ ;
                else if(board[i].charAt(j) == 'O') o++ ;
            }
        }

        if(o > x || x - o > 1) return false ;
        boolean xwin = winner(board,'X') ;
        boolean owin = winner(board,'O') ;
        if(xwin && owin) return false ;
        if(xwin && x == o) return false ;
        if(owin && x > o) return false ;
        return true ;
    }
    boolean winner(String board[],char player){
        for(int i = 0 ; i < 3 ; i++){
            if(board[i].charAt(0) == player && board[i].charAt(1) == player && board[i].charAt(2) == player) return true ;
            else if(board[0].charAt(i) == player && board[1].charAt(i) == player && board[2].charAt(i) == player) return true ;
        }

        if(board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player) return true ;
        if(board[0].charAt(2) == player && board[1].charAt(1) == player && board[2].charAt(0) == player) return true ;
        return false ;
    }
}