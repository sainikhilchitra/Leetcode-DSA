class Solution {
    public int[] separateDigits(int[] nums) {
        
        int n = nums.length ;

        ArrayList<Integer> al = new ArrayList<>() ;

        for(int i = 0 ; i < n ; i++){
            int ele = nums[i] ;
            ArrayList<Integer> temp = new ArrayList<>() ;
            while(ele != 0){
                temp.add(ele % 10) ;
                ele /= 10 ;
            }

            for(int j = temp.size() - 1 ; j >= 0 ; j--){
                al.add(temp.get(j)) ;
            }
        }

        int res[] = new int[al.size()] ;

        for(int i = 0 ; i < al.size() ; i++){
            res[i] = al.get(i) ;
        }

        return res ;
    }
}