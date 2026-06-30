class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>() ;
        for(int i = 0 ; i < arr.length ; i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0) + 1) ;
        }

        int freq[] = new int[hm.size()] ;
        int j = 0 ;
        for(int val : hm.values()){
            freq[j++] = val ;
        }
        Arrays.sort(freq) ;
        int i = 0 ;
        while(i != j && k >= freq[i]){
            k -= freq[i] ;
            i++ ;
        }

        return j - i ;
    }
}