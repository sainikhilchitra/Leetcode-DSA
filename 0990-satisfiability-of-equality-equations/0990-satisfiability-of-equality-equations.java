class Solution {
    int parent[] = new int[26] ;
    int findParent(int i){
        if(parent[i] == i) return i ;
        return parent[i] = findParent(parent[i]) ;
    }
    public boolean equationsPossible(String[] equations) {
        for(int i = 0 ; i < 26 ; i++){
            parent[i] = i ;
        }
        for(String eq : equations){
            if(eq.charAt(1) == '!') continue ;
            int pu = findParent(eq.charAt(0) - 'a') ;
            int pv = findParent(eq.charAt(3) - 'a') ;
            if(pu == pv) continue ;
            parent[pv] = pu ;
        }
        for(String eq : equations){
            if(eq.charAt(1) == '=') continue ;
            int pu = findParent(eq.charAt(0) - 'a') ;
            int pv = findParent(eq.charAt(3) - 'a') ;
            if(pu == pv) return false ;
        }
        return true ;
    }
}