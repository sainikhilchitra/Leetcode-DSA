class RideSharingSystem {

    Queue<Integer> rider ;
    Queue<Integer> driver ;
    HashSet<Integer> hs ;
    public RideSharingSystem() {
        rider = new LinkedList<>() ;
        driver = new LinkedList<>() ;
        hs = new HashSet<>() ;
    }
    
    public void addRider(int riderId) {
        rider.offer(riderId) ;
        hs.add(riderId) ;
    }
    
    public void addDriver(int driverId) {
        driver.offer(driverId) ;
    }
    
    public int[] matchDriverWithRider() {
        int res[] = {-1 , -1} ;
        
        while(!rider.isEmpty() && !hs.contains(rider.peek())){
            rider.poll() ;
        }
        
        if(rider.isEmpty() || driver.isEmpty()) return res ;

        hs.remove(rider.peek()) ;

        res[0] = driver.poll() ;
        res[1] = rider.poll() ;

        return res ;
    }
    
    public void cancelRider(int riderId) {
        if(hs.contains(riderId)){
            hs.remove(riderId) ;
        }
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */