class Solution {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE ;
        for(int ele : nums){
            if(ele > first){
                third = second ;
                second = first ;
                first = ele ;
            }
            else if(ele > second && ele < first){
                third = second ;
                second = ele ;
            }
            else if(ele > third && ele < second){
                third = ele ;
            }
        }
        if(third == Long.MIN_VALUE) return (int)first ;
        return (int)third ;
    }
}