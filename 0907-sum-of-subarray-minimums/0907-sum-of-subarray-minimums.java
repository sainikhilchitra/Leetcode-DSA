class Solution {
    long mod = (long)1e9 + 7 ;
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length ;
        int left[] = new int[n] ;
        int right[] = new int[n] ;
        Stack<Integer> stk = new Stack<>() ;
        for(int i = 0 ; i < n ; i++){
            while(!stk.isEmpty() && arr[stk.peek()] >= arr[i]){
                stk.pop() ;
            }
            left[i] = i - (stk.isEmpty() ? -1 : stk.peek()) ;
            stk.push(i) ;
        }
        stk = new Stack<>() ;
        for(int i = n - 1 ; i >= 0 ; i--){
            while(!stk.isEmpty() && arr[stk.peek()] > arr[i]){
                stk.pop() ;
            }
            right[i] = (stk.isEmpty() ? n : stk.peek()) - i ;
            stk.push(i) ;
        }
        long ans = 0 ;
        for(int i = 0 ; i < n ; i++){
            ans = (ans + left[i] * 1L * arr[i] * right[i]) % mod ;
        }
        return (int) ans ;
    }
}