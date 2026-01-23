class Solution {
    List<List<String>> res = new ArrayList<>() ;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> hs = new HashSet<>() ;
        for(int i = 0 ; i < wordList.size() ; i++){
            hs.add(wordList.get(i)) ;
        }
        
        HashMap<String,Integer> hm = new HashMap<>() ;
        Queue<String> q = new LinkedList<>() ;
        q.offer(beginWord) ;
        hs.remove(beginWord) ;

        int level = 0 , maxLevel = -1;
        while(!q.isEmpty()){
            int size = q.size() ;
            ArrayList<String> remove = new ArrayList<>() ;

            while(size-- > 0){
                
                String str = q.poll() ;
                if(endWord.equals(str)){
                    maxLevel = level ;
                }
                if(hm.containsKey(str)){
                    continue ;
                }

                hm.put(str,level) ;
                StringBuilder sb = new StringBuilder(str) ;
                for(int i = 0 ; i < str.length() ; i++) {
                    char original = str.charAt(i) ;

                    for(char ch = 'a' ; ch <= 'z' ; ch++){
                        sb.setCharAt(i,ch) ;
                        String s = sb.toString() ;
                        if(hs.contains(s)){
                            q.offer(s) ;
                            remove.add(s) ;
                        }
                    }
                    sb.setCharAt(i,original) ;
                }
            }
            level++ ;
            if(maxLevel != -1) break ;

            for(String ele : remove){
                hs.remove(ele) ;
            }
        }

        if(maxLevel == -1) return res ;
        
        ArrayList<String> al = new ArrayList<>() ;
        al.add(endWord) ;
        dfs(hm,al,endWord,maxLevel) ;

        return res ;
    }

    void dfs(HashMap<String,Integer> hm,ArrayList<String> al,String str,int level){
        if(level == 0) {
            ArrayList<String> path = new ArrayList<>(al) ;
            Collections.reverse(path) ;
            res.add(path) ;
            return ;
        }
        StringBuilder sb = new StringBuilder(str) ;
        for(int i = 0 ; i < str.length() ; i++){
            char original = str.charAt(i) ;
            for(char ch = 'a' ; ch <= 'z' ; ch++){
                sb.setCharAt(i,ch) ;
                String s = sb.toString() ;
                if(hm.containsKey(s) && hm.get(s) + 1 == level) {
                    al.add(s) ;
                    dfs(hm,al,s,level - 1) ;
                    al.remove(al.size() - 1) ;
                }
            }
            sb.setCharAt(i,original) ;
        }
    }

    // public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
    //     // Traditional approach 
    //     HashSet<String> hs = new HashSet<>() ;
    //     for(int i = 0 ; i < wordList.size() ; i++){
    //         hs.add(wordList.get(i)) ;
    //     }
       
    //    Queue<ArrayList<String>> q = new LinkedList<>() ;
    //    q.offer(new ArrayList<>()) ;
    //     q.peek().add(beginWord) ;
    //     hs.remove(beginWord) ;

    //     List<List<String>> res = new ArrayList<>() ;
    //     while(!q.isEmpty()){
    //         int size = q.size() ;
    //         HashSet<String> remove = new HashSet<>() ;
    //         boolean found = false ;
    //         while(size-- > 0){
    //             ArrayList<String> list = q.poll() ;
    //             String str = list.get(list.size() - 1) ;
    //             if(str.equals(endWord)){
    //                 res.add(list) ;
    //                 found = true ;
    //                 continue ;
    //             }
    //             StringBuilder sb = new StringBuilder(str) ;
    //             for(int i = 0 ; i < str.length() ; i++){
    //                 char original = str.charAt(i) ;

    //                 for(char ch = 'a' ; ch <= 'z' ; ch++){
    //                     if(original == ch) continue ;
    //                     sb.setCharAt(i,ch) ;
    //                     String s = sb.toString() ;
    //                     if(hs.contains(s)){
    //                         list.add(s) ;
    //                         q.offer(new ArrayList<>(list)) ;
    //                         list.remove(list.size() - 1);
    //                         remove.add(s) ;
    //                     }
    //                 }

    //                 sb.setCharAt(i,original) ;
    //             }
    //         }
    //         if(found) return res ;

    //         for(String r : remove){
    //             hs.remove(r) ;
    //         }

    //     }
    //     return res ;
    // }
}