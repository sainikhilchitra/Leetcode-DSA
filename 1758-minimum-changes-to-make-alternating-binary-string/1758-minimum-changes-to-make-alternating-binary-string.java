class Solution {
    public int minOperations(String s) {
        int n = s.length() ;

        StringBuilder sb1= new StringBuilder() ;

        boolean set = false ;

        for(int i = 0 ; i < n ; i++){
            if(set){
                sb1.append('1') ;
            }
            else{
                sb1.append('0') ;
            }

            set = !set ;
        }

        int cost1 = 0, cost2 = 0 ;

        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) != sb1.charAt(i)){
                cost1++ ;
            }
            else{
                cost2++ ;
            }
        }

        return Math.min(cost1,cost2) ;
    }
}