class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        HashMap<Integer,Integer> hm = new HashMap<>() ;

        for(int i = 0 ; i < nums1.length ; i++){
            hm.put(nums1[i],hm.getOrDefault(nums1[i],0) + 1) ;
        }

        ArrayList<Integer> temp = new ArrayList<>() ;

        for(int i = 0 ; i < nums2.length ; i++){
            if(hm.containsKey(nums2[i])){
                temp.add(nums2[i]) ;
                hm.put(nums2[i],hm.get(nums2[i]) - 1) ;
            }
            if(hm.containsKey(nums2[i]) && hm.get(nums2[i]) == 0){
                hm.remove(nums2[i]) ;
            }
        }

        int res[] = new int[temp.size()] ;

        for(int i = 0 ; i < temp.size() ; i++){
            res[i] = temp.get(i) ;
        }
        return res ;
    }
}