class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>() ;
        for(int i = 0 ; i < asteroids.length ; i++){
            if(asteroids[i] > 0){
                stk.push(asteroids[i]) ;
            }
            else{
                if(stk.isEmpty() || stk.peek() < 0){
                    stk.push(asteroids[i]) ;
                }
                else{
                    if(stk.peek() < Math.abs(asteroids[i])){
                        stk.pop() ;
                        i-- ;
                    }
                    else if(stk.peek() == Math.abs(asteroids[i])){
                        stk.pop() ;
                    }
                }
            }
        }

        int size = stk.size() ;

        int arr[] = new int[size] ;

        for(int i = size - 1 ; i >= 0 ; i--){
            arr[i] = stk.pop() ;
        }

        return arr ;
    }
}