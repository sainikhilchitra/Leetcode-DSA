class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs = new HashSet<>() ;

        for(int i = 0 ; i < wordList.size() ; i++){
            hs.add(wordList.get(i)) ;
        }

        Queue<String> q = new LinkedList<>() ;
        q.offer(beginWord) ;
        hs.remove(beginWord) ;

        int level = 1 ;
        while(!q.isEmpty()){
            int size = q.size() ;
            for(int i = 0 ; i < size ; i++){
                String str = q.poll() ;
                if(str.equals(endWord)) return level ;
                StringBuilder sb = new StringBuilder(str) ;

                for(int j = 0 ; j < beginWord.length() ; j++){
                    char original = sb.charAt(j) ;
                    for(char ch = 'a' ; ch <= 'z' ; ch++){
                        sb.setCharAt(j,ch) ;
                        String s = sb.toString() ;
                        if(hs.contains(s)){
                            q.offer(s) ;
                            hs.remove(s) ;
                        }
                    }
                    sb.setCharAt(j,original) ;
                }
            }
            level++ ;
        }

        return  0 ;
    }
}