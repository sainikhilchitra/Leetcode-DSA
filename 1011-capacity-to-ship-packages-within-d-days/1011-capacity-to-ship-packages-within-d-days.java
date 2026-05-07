class Solution {

    boolean isValid(int weight[],int days,int k){

        int count = 0, sum = 0 ;
        for(int i = 0 ; i < weight.length ; i++){
            sum += weight[i] ;
            if(sum > k){
                sum = weight[i] ;
                count++ ;
            }
        }

        return count + 1 <= days ;
    }

    public int shipWithinDays(int[] weights, int days) {
        
        int low = 0, high = 0 ;
        for(int i = 0 ; i < weights.length ; i++){
            low = Math.max(low,weights[i]) ;
            high += weights[i] ;
        }

        int ans = -1 ;
        while(low < high){
            int mid = (low + high) / 2 ;

            if(isValid(weights,days,mid)){
                ans = mid ;
                high = mid - 1 ;
            }
            else{
                low = mid + 1 ;
            }
        }

        return ans ;
    }
}