class Solution {
    public int minimumOR(int[][] grid) {

        int ans = 0 ;
        int n = grid.length ;
        int m = grid[0].length ;

        ArrayList<Integer> rows[] = new ArrayList[n] ;

        for(int i = 0 ; i < n ; i++){
            ArrayList<Integer> al = new ArrayList<>() ;

            for(int j = 0 ; j < m ; j++){
                al.add(grid[i][j]) ;
            }
            rows[i] = al ;
        }
        
        for(int bit = 16 ; bit >= 0 ; bit--){
            
            ArrayList<Integer> elements[] = new ArrayList[n] ;

            boolean isPossible = true ;

            for(int i = 0 ; i < n ; i++){
                elements[i] = new ArrayList<>() ;

                for(int val : rows[i]){
                    if(((val >> bit) & 1) == 0){
                        elements[i].add(val) ;
                    }
                }

                if(elements[i].isEmpty()){
                    isPossible = false ;
                    break ;
                }
            }

            if(isPossible){
                rows = elements ;
            }
            else{
                ans = (ans | (1 << bit)) ;
            }
        }

        return ans ;
    }
}