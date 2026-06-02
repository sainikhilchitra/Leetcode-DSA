class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n=landStartTime.length;
        int m=waterStartTime.length;
        int res=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int landTravelTime=landStartTime[i]+landDuration[i];
                int waterStartAfterLand=Math.max(waterStartTime[j],landTravelTime);
                int totalLandWater=waterStartAfterLand+waterDuration[j];

                int waterTravelTime=waterStartTime[j]+waterDuration[j];
                int landStartAfterWater=Math.max(landStartTime[i],waterTravelTime);
                int totalWaterLand=landStartAfterWater+landDuration[i];

                res=Math.min(res,Math.min(totalWaterLand,totalLandWater));
            }
        }
        return res;
    }
}