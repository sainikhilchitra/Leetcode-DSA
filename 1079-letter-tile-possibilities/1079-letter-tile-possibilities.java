class Solution {
    HashSet<String> hs = new HashSet<>() ;
    void bt(String tiles,int cnt,String cur,boolean visited[]){
        if(cnt == tiles.length()){
            if(cur.length() == 0) return ;
            hs.add(cur) ;
            return ;
        }
        for(int i = 0 ; i < tiles.length() ; i++){
            if(!visited[i]){
                visited[i] = true ;
                bt(tiles,cnt + 1,cur + tiles.charAt(i),visited) ;
                visited[i] = false ;
            }
        }
        bt(tiles,cnt + 1,cur,visited) ;
    }
    public int numTilePossibilities(String tiles) {
        bt(tiles,0,"",new boolean[tiles.length()]) ;
        return hs.size() ;
    }
}