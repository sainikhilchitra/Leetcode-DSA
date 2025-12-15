class Pair{
    char ch ;
    int count;
    Pair(char ch){
        this.ch = ch ;
        this.count = 1 ;
    }
}
class Solution {
    public String frequencySort(String s) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.count != b.count) return b.count - a.count ;
            return a.ch - b.ch ;
        }) ;

        HashMap<Character,Integer> hm = new HashMap<>() ;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i) ;
            hm.put(ch,hm.getOrDefault(ch,0) + 1) ;
        }

        for(char ch:hm.keySet()){
            Pair p = new Pair(ch) ;
            p.count = hm.get(ch) ;
            pq.offer(p) ;
        }

        StringBuilder sb = new StringBuilder() ;

        while(!pq.isEmpty()){
            Pair p = pq.poll() ;
            for(int i=0;i<p.count;i++){
                sb.append(p.ch) ;
            }
        }

        return sb.toString() ;
    }
}