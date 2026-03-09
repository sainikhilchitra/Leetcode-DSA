class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b)->{
            return a[0] - b[0] ;
        }) ;

        int n = intervals.length ;
        int size = -1 ;

        int start[] = new int[n] ;
        int end[] = new int[n] ;

        for(int i = 0 ; i < n ; i++){

            if(size != -1 && end[size] >= intervals[i][0]){
                end[size] = Math.max(intervals[i][1],end[size]) ;
            }
            else{
                size++ ;
                start[size] = intervals[i][0] ;
                end[size] = intervals[i][1] ;
            }
        }

        int res[][] = new int[size + 1][2] ;

        for(int i = 0 ; i <= size ; i++){
            res[i][0] = start[i] ;
            res[i][1] = end[i] ;
        }

        return res ;
    }
}