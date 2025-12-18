class Trie{
    int count ;
    Trie child[] ;
    Trie(){
        child = new Trie[26] ;
    }
}
class Solution {
    void insert(Trie root, String s){
        for(int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - 'a' ;
            if(root.child[idx] == null){
                root.child[idx] = new Trie() ;
            }
            root = root.child[idx] ;
            root.count++ ;
        }
    }

    String search(Trie root, int n, String str[]){
        String s = str[0] ;
        StringBuilder sb = new StringBuilder() ;
         for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i) ;
            root = root.child[ch - 'a'] ;
            if(root.count == n){
                sb.append(ch) ;
            }
            else{
                break ;
            }
         }
         return sb.toString() ;
    }
    public String longestCommonPrefix(String[] strs) {
        Trie root = new Trie() ;
        int n = strs.length ;

        for(int i = 0; i < n; i++){
            insert(root,strs[i]) ;
        }
        return search(root,n,strs) ;
    }
}