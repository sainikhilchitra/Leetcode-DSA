class Solution {
    boolean check(int count[],int k){
        int sum = 0, max = 0 ;
        for(int i = 0 ; i < 26 ; i++){
            sum += count[i] ;
            max = Math.max(max,count[i]) ;
        }
        return sum - max <= k ;
    }
    public int characterReplacement(String s, int k) {
        int length = s.length() ;
        int count[] = new int[26] ;
        int len = 0 ;
        for(int j = 0 ; j < Math.min(k + 1,length) ; j++){
            count[s.charAt(j) - 'A']++ ;
        }

        int ans = Math.min(length,k + 1), i = 0 ;
        for(int j = k + 1 ; j < length ; j++){
            count[s.charAt(j) - 'A']++ ;
            if(!check(count, k)){
                while(j - i + 1 > k + 1 && !check(count, k)){
                    count[s.charAt(i) - 'A']-- ;
                    i++ ;
                }
            }
            ans = Math.max(ans,j - i + 1) ;
            System.out.println(j+" "+ans) ;
        }
        return ans ;
    }
}