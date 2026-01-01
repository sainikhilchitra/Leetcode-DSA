class Solution {
    int[] smallOnLeft(int arr[],int n){
        int small[] = new int[n] ;
        Stack<Integer> stk = new Stack<>() ;
        stk.push(-1) ;
        for(int i = 0 ; i < n ; i++){
            while(!stk.isEmpty() && stk.peek() != -1 && arr[stk.peek()] >= arr[i]){
                stk.pop() ;
            }
            small[i] = stk.peek() ;
            stk.push(i) ;
        }
        return small ;
    }

    int[] smallOnRight(int arr[],int n){
        int small[] = new int[n] ;
        Stack<Integer> stk = new Stack<>() ;
        stk.push(n) ;
        for(int i = n-1 ; i >= 0 ; i--){
            while(!stk.isEmpty() && stk.peek() != n && arr[stk.peek()] >= arr[i]){
                stk.pop() ;
            }
            small[i] = stk.peek() ;
            stk.push(i) ;
        }
        return small ;
    }

    int maxSum(int arr[],int n){
        int max = 0 ;
        int preSmall[] = smallOnLeft(arr,n) ;
        int sufSmall[] = smallOnRight(arr,n) ;

        for(int i = 0 ; i < n ; i++){
            int width = sufSmall[i] - preSmall[i] - 1 ;
            max = Math.max(max,width * arr[i]) ;
        }

        return max ;
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