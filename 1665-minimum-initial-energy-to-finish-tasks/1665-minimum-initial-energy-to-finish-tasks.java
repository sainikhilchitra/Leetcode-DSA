class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks,(a,b)->{
            return (b[1] - b[0]) - (a[1] - a[0]) ;
        }) ;

        int start = 0 ;
        int total = 0 ;

        for(int arr[] : tasks){
            int act = arr[0] ;
            int min = arr[1] ;

            if(start < min){
                total += min - start ; 
                start = min ;
            }
            start -= act ;
        }

        return total ;

    }
}