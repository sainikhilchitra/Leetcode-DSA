class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>() ;

        int n = heights.length ;
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
}