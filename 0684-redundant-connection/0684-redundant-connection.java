class Solution {
    int findParent(int parent[],int node){
        if(parent[node] == node) return node ;
        parent[node] = findParent(parent,parent[node]) ;
        return parent[node] ;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length ;
        int parent[] = new int[n+1] ;

        for(int i = 1 ; i <= n ; i++){
            parent[i] = i ;
        }

        int res[] = new int[2] ;

        for(int[] edge : edges){
            int pu = findParent(parent,edge[0]) ;
            int pv = findParent(parent,edge[1]) ;
            int maxi = Math.max(pu,pv) ;
            int mini = Math.min(pu,pv) ;
            if(pu != pv){
                parent[maxi] = mini ;
            }
            else{
                res[0] = edge[0] ;
                res[1] = edge[1] ;
            }
        }

        return res ;
    }
}