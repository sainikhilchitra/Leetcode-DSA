class Solution {
    public int maxSum(int[] heights, int n) {
        Stack<Integer> stk = new Stack<>() ;

        long maxArea = 0 ;
        for(int i = 0 ; i < n ; i++){
            while(!stk.isEmpty() && heights[i] <= heights[stk.peek()]){
                int height = heights[stk.pop()] ;
                int width = i - 1 - (stk.isEmpty() ? -1 : stk.peek()) ;
                maxArea = Math.max(maxArea , height * width) ;
            }
            stk.push(i) ;
        }

        while(!stk.isEmpty()){
            int height = heights[stk.pop()] ;
            int width = n - 1 - (stk.isEmpty() ? -1 : stk.peek()) ;
            maxArea = Math.max(maxArea , height * width) ;
        }

        return (int) maxArea ;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length ;
        int m = matrix[0].length ;
        int ans = 0 ;
        int height[][] = new int[n+1][m] ;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(matrix[i-1][j] == '0'){
                    height[i][j] = 0 ;
                }
                else{
                    height[i][j] = height[i-1][j] + 1 ;
                }
            }
            ans = Math.max(ans,maxSum(height[i],m)) ;
        }
        return ans ;
    }
}