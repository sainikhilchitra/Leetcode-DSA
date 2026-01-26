class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr) ;

        int minDiff = Integer.MAX_VALUE ;
        int n = arr.length ;
        for(int i = 1 ; i < n ; i++){
            minDiff = Math.min(minDiff,arr[i] - arr[i - 1]) ;
        }

        List<List<Integer>> res = new ArrayList<>() ;

        for(int i = 1 ; i < n ; i++){
            int dif = arr[i] - arr[i - 1] ;
            if(dif == minDiff){
                ArrayList<Integer> al = new ArrayList<>() ;
                al.add(arr[i - 1]) ;
                al.add(arr[i]) ;

                res.add(al) ;
            }
        }

        return res ;
    }
}