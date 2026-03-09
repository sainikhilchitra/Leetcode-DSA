class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b)->{
            return a[0] - b[0] ;
        }) ;
        int n = intervals.length ;
        int size = 0 ;

        int start[] = new int[n] ;
        int end[] = new int[n] ;

        for(int i = 0 ; i < n ; i++){
            boolean found = false ;
            for(int j = 0 ; j < size ; j++){

                if(end[j] >= intervals[i][0]){
                    end[j] = Math.max(intervals[i][1],end[j]) ;
                    found = true ;
                    break ;
                }

            }

            if(!found){
                start[size] = intervals[i][0] ;
                end[size] = intervals[i][1] ;
                size++ ;
            }
        }

        int res[][] = new int[size][2] ;

        for(int i = 0 ; i < size ; i++){
            res[i][0] = start[i] ;
            res[i][1] = end[i] ;
        }

        return res ;
    }
}