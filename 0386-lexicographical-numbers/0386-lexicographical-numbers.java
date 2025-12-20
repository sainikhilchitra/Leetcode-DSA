class Solution {
    List<Integer> res = new ArrayList<>() ;
    void generate(int n,int cur){
        if(cur > n) return ;
        res.add(cur) ;
        for(int i = 0; i <= 9; i++){
            generate(n,cur*10+i) ;
        }
    }
    public List<Integer> lexicalOrder(int n) {
        for(int i = 1; i <= 9 ;i++){
            generate(n,i) ;
        }
        return res ;
    }
}