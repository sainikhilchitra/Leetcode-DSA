class Solution {
    public int prefixConnected(String[] words, int k) {

        HashMap<String,Integer> hm = new HashMap<>() ;

        for(String s : words){
            if(s.length() < k) continue ;

            String str = s.substring(0,k) ;

            hm.put(str,hm.getOrDefault(str,0) + 1) ;
        }

        int count = 0 ;

        for(int freq : hm.values()){
            if(freq >= 2){
                count++ ;
            }
        }

        return count ;
    }
}