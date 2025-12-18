class TrieNode{
    TrieNode child[] ;
    boolean end ;

    TrieNode(){
        child = new TrieNode[26] ;
        end = false ;
    }
}
class Trie {
    TrieNode root ;

    public Trie() {
        root = new TrieNode() ;
    }
    
    public void insert(String word) {
        TrieNode temp = root ;
        char ch[] = word.toCharArray() ;
        for(int i = 0; i < ch.length; i++){
            int idx = ch[i] - 'a' ;
            if(temp.child[idx] == null){
                temp.child[idx] = new TrieNode() ;
            }
            temp = temp.child[idx] ;
        }
        temp.end = true ;
    }
    
    public boolean search(String word) {
        TrieNode temp = root ;
        char ch[] = word.toCharArray() ;
        for(int i = 0; i < ch.length; i++){
            int idx = ch[i] - 'a' ;
            if(temp.child[idx] == null) return false ;
            temp = temp.child[idx] ;
        }
        return temp.end ;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode temp = root ;
        char ch[] = prefix.toCharArray() ;
        for(int i = 0; i < ch.length; i++){
            int idx = ch[i] - 'a' ;
            if(temp.child[idx] == null) return false ;
            temp = temp.child[idx] ;
        }
        return true ;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */