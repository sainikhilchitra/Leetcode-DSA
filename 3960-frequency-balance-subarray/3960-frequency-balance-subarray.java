class Solution {
    boolean isBalanced(HashMap<Integer,Integer> hm,int max){
        if(hm.size() == 1) return true ;
        int count = 0 ;
        for(Map.Entry<Integer,Integer> entry: hm.entrySet()){
            int freq = entry.getValue() ;
            if(freq == max) continue ;
            else if(freq * 2 != max) return false ;
            count++ ;
        }
        if(count == 0) return false ;
        return true ;
    }
    public int getLength(int[] nums) {

        int len = 1 ;
        for(int i = 0 ; i < nums.length ; i++){
            HashMap<Integer,Integer> hm = new HashMap<>() ;
            int max = 1 ;
            for(int j = i ; j < nums.length ; j++){
                hm.put(nums[j],hm.getOrDefault(nums[j],0) + 1) ;
                max = Math.max(max,hm.get(nums[j])) ;
                if(max > 1 && isBalanced(hm,max)){
                    len = Math.max(len,j - i + 1) ;
                }
            }
        }

        return len ;
    }
}