class Solution {
    public int maxNumberOfBalloons(String text) {
        int count[] = new int[26] ;

        for(char ch : text.toCharArray()){
            count[ch - 'a']++ ;
        }
        return Math.min(count['b' - 'a'], Math.min(count['a' - 'a'],Math.min(count['l' - 'a'] / 2,Math.min(count['o' - 'a'] / 2,count['n' - 'a'])))) ;
    }
}