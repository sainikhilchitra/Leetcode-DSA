class DSU{
    HashMap<Integer,Integer> parent = new HashMap<>() ;
    int find(int x){
        if(!parent.containsKey(x)){
            parent.put(x,x) ;
        }
        if(x != parent.get(x)){
            parent.put(x,find(parent.get(x))) ;
        }
        return parent.get(x) ;
    }
    void union(int u,int v){
        int pu = find(u) ;
        int pv = find(v) ;
        if(pu != pv){
            int maxi = Math.max(pu,pv) ;
            int mini = Math.min(pu,pv) ;
            parent.put(maxi,mini) ;
        }
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[2] - b[2] ;
        }) ;
        for(int i = 0 ; i < points.length ; i++){
            for(int j = 0 ; j < points.length ; j++){
                if(i == j) continue ;
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]) ;
                pq.offer(new int[]{i,j,dist}) ;
            }
        }
        DSU d = new DSU() ;
        int ans = 0 ;
        while(!pq.isEmpty()){
            int temp[] = pq.poll() ;
            int pu = d.find(temp[0]) ;
            int pv = d.find(temp[1]) ;
            if(pu != pv){
                d.union(temp[0],temp[1]) ;
                ans += temp[2] ;
            }
        }
        return ans ;
    }
}