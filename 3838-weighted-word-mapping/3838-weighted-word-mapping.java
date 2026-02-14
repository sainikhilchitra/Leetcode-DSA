class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder() ;

        for(String s : words){
            int sum = 0 ;
            for(char ch : s.toCharArray()){
                sum += weights[ch - 'a'] ;
            }
            sum = sum % 26 ;

            ans.append((char)('a' + 25 - sum));
        }

        return ans.toString() ;
    }
}