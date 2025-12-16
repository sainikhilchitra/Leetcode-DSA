class Trie{
    Trie child[] ;
    Trie(){
        child = new Trie[2] ;
    }
}
class Solution {
    int search(Trie root, int num){
        int ans = 0 ;
        for(int i = 31; i >= 0; i--){
            ans <<= 1 ;
            int bit = (num >> i) & 1 ;
            int rbit = 1 - bit ;
            if(root.child[rbit] != null){
                ans = ans | rbit ;
                root = root.child[rbit] ;
            }
            else{
                ans = ans | bit ;
                root = root.child[bit] ;
            }
        }
        return ans ;
    }

    void insert(Trie root, int num){
        for(int i = 31; i >= 0; i--){
            int bit = (num >> i) & 1 ;
            if(root.child[bit] == null){
                Trie x = new Trie() ;
                root.child[bit] = x ;
            }
            root = root.child[bit] ;
        }
    }
    public int findMaximumXOR(int[] nums) {
        int n = nums.length ;
        Trie root = new Trie() ;
        for(int i = 0; i < n; i++){
            insert(root,nums[i]) ;
        }

        int max = Integer.MIN_VALUE ;

        for(int i = 0; i < n; i++){
            max = Math.max(max, search(root,nums[i])^nums[i]) ;
        }

        return max ;
    }
}