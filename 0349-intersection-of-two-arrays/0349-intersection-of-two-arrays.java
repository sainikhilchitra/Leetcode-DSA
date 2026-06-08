class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer> hs = new HashSet<>() ;

        for(int i = 0 ; i < nums1.length ; i++){
            hs.add(nums1[i]) ;
        }

        ArrayList<Integer> temp = new ArrayList<>() ;
        for(int i = 0 ; i < nums2.length ; i++){
            if(hs.contains(nums2[i])){
                temp.add(nums2[i]) ;
                hs.remove(nums2[i]) ;
            }
        }

        int res[] = new int[temp.size()] ;

        for(int i = 0 ; i < temp.size() ; i++){
            res[i] = temp.get(i) ;
        }

        return res ;
    }
}