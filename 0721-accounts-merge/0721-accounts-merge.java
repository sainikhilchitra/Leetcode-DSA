class DSU{
    HashMap<String,String> parent = new HashMap<>() ;
    String find(String s){
        if(!parent.containsKey(s)){
            parent.put(s,s) ;
        }
        if(!s.equals(parent.get(s))){
            parent.put(s,find(parent.get(s))) ;
        }
        return parent.get(s) ;
    }

    void union(String a,String b){
        String pu = find(a) ;
        String pv = find(b) ;
        if(!pu.equals(pv)){
            parent.put(pv,pu) ;
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU d = new DSU() ;
        HashMap<String,String> emailToName = new HashMap<>() ;
        for(List<String> acc : accounts){
            String name = acc.get(0) ;
            String firstEmail = acc.get(1) ;
            emailToName.put(firstEmail,name) ;
            for(int i = 1 ; i < acc.size() ; i++){
                String email = acc.get(i) ;
                d.union(firstEmail,email) ;
            }
        }
        HashMap<String,ArrayList<String>> group = new HashMap<>() ;
        for(String email:d.parent.keySet()){
            String parent = d.find(email) ;
            if(!group.containsKey(parent)){
                group.put(parent,new ArrayList<>()) ;
            }
            group.get(parent).add(email) ;
        }
        List<List<String>> res = new ArrayList<>() ;
        for(String acc : group.keySet()){
            ArrayList<String> temp = new ArrayList<>() ;
            temp.add(emailToName.get(acc)) ;
            ArrayList<String> emails = group.get(acc) ;
            Collections.sort(emails) ;
            temp.addAll(emails) ;
            res.add(temp) ;
        }
        return res ;
    }

}