class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int n = intervals.length ;
        Arrays.sort(intervals,(a,b)->{
            return a[0] - b[0] ;
        }) ;

        ArrayList<int[]> res = new ArrayList<>() ;

        int i = 0 ;
        for( ; i < n ; i++){
            if(intervals[i][0] > newInterval[0]) break ;
            if(res.size() == 0){
                res.add(intervals[i]) ;
            }
            else if(intervals[i][0] <= res.get(res.size() - 1)[1]){
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1],intervals[i][1]) ;
            }
            else{
                res.add(intervals[i]) ;
            }
        }

        if(res.size() == 0){
            res.add(newInterval) ;
        }
        else if(newInterval[0] <= res.get(i - 1)[1]){
            res.get(i - 1)[1] = Math.max(res.get(i - 1)[1],newInterval[1]) ;
        }
        else{
            res.add(newInterval) ;
        }

        for(; i < n ; i++){
            int cur[] = intervals[i] ;
            if(cur[0] <= res.get(res.size() - 1)[1]){
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1],cur[1]) ;
            }
            else{
                res.add(cur) ;
            }
        }

        int send[][] = new int[res.size()][2] ;

        for(i = 0 ; i < res.size() ; i++){
            send[i][0] = res.get(i)[0] ;
            send[i][1] = res.get(i)[1] ;
        }

        return send ;
    }
}