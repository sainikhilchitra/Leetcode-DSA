class Solution {

    int length(int n){
        if(n == 0) return 1 ;
        int len = 0 ;
        while(n != 0){
            len++ ;
            n /= 10 ;
        }
        return len ;
    }
    
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> hs = new HashSet<>() ;

        for(int i = 0 ; i < arr1.length ; i++){
            int ele = arr1[i] ;
            while(ele != 0){
                hs.add(ele) ;
                ele /= 10 ;
            }
        }

        int ans = 0 ;

        for(int i = 0 ; i < arr2.length ; i++){
            int ele = arr2[i] ;

            while(ele != 0){
                if(hs.contains(ele)){
                    ans = Math.max(ans,length(ele)) ;
                }
                ele /= 10 ;
            }
        }

        return ans ;
    }
}