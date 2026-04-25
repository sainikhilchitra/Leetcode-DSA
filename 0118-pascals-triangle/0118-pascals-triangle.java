class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>() ;
        ArrayList<Integer> prev = new ArrayList<>() ;
        prev.add(1) ;
        res.add(prev) ;
        for(int i = 1 ; i < numRows ; i++){
            ArrayList<Integer> al = new ArrayList<>() ;
            int n = prev.size() ;
            al.add(1) ;
            for(int j = 1 ; j < n ; j++){
                al.add(prev.get(j - 1) + prev.get(j)) ;
            }
            al.add(1) ;
            prev = new ArrayList(al) ;
            res.add(prev) ;
        }

        return res ;
    }
}