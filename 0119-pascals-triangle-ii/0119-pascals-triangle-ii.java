class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>() ;
        prev.add(1) ;

        for(int i = 1 ; i <= rowIndex ; i++){
            ArrayList<Integer> al = new ArrayList<>() ;
            al.add(1) ;
            for(int j = 1 ; j < prev.size() ; j++){
                al.add(prev.get(j - 1) + prev.get(j)) ;
            }
            al.add(1) ;

            prev = al ;
        }

        return prev ;
    }
}