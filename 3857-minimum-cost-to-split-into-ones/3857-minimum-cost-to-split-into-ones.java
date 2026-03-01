class Solution {
    public int minCost(int n) {

        long num = n ;
        long cost = (num * (num - 1)) / 2 ;

        return (int) cost ;
    }
}