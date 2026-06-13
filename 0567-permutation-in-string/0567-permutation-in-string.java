class Solution {
    boolean check(int count1[],int count2[]){
        for(int i = 0 ; i < 26 ; i++){
            if(count2[i] < count1[i]) return false ;
        }
        return true ;
    }
    public boolean checkInclusion(String s1, String s2) {
        
        int count1[] = new int[26] ;
        int count2[] = new int[26] ;

        for(int i = 0 ; i < s1.length() ; i++){
            count1[s1.charAt(i) - 'a']++ ;
        }

        int i = 0 ;
        for(int j = 0 ; j < s2.length() ; j++){
            count2[s2.charAt(j) - 'a']++ ;
            while(check(count1,count2)){
                if(j - i + 1 == s1.length()) return true ;
                count2[s2.charAt(i) - 'a']-- ;
                i++ ;
            }
        }

        return false ;
    }
}