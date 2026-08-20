class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String,ArrayList<String>> graph = new HashMap<>() ;
        int indegree[] = new int[recipes.length] ;
        HashMap<String,Integer> hm = new HashMap<>() ;
        for(int i = 0 ; i < recipes.length ; i++){
            hm.put(recipes[i],i) ;
            for(String s : ingredients.get(i)){
                if(!graph.containsKey(s)){
                    graph.put(s,new ArrayList<>()) ;
                }
                graph.get(s).add(recipes[i]) ;
                indegree[i]++ ;
            }
        }

        Queue<String> q = new LinkedList<>() ;
        for(String s : supplies) q.offer(s) ;

        List<String> res = new ArrayList<>() ;
        while(!q.isEmpty()){
            String s = q.poll() ;
            if(!graph.containsKey(s)) continue ;
            for(String y : graph.get(s)){
                indegree[hm.get(y)]-- ;
                if(indegree[hm.get(y)] == 0){
                    q.offer(y) ;
                    res.add(y) ;
                }
            }
        }
        return res ;
    }
}