class Node{
    int key ;
    int val ;
    Node prev ;
    Node next ;
    Node(int key,int val){
        this.key = key ;
        this.val = val ;
        next = null ;
        prev = null ;
    }
}
class LRUCache {
    HashMap<Integer,Node> hm = new HashMap<>() ;
    Node dummy ;
    Node tail ;
    int capacity = 0 ;
    public LRUCache(int capacity) {
        dummy = new Node(-1,-1) ;
        tail = new Node(-1,-1) ;
        dummy.next = tail ;
        tail.prev = dummy ;
        this.capacity = capacity ;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            Node node = hm.get(key) ;
            remove(node) ;
            insertAtTail(node) ;
            return node.val ;
        }
        else{
            return -1 ;
        }
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node node = hm.get(key) ;
            node.val = value ;
            remove(node) ;
            insertAtTail(node) ;
        }
        else{
            if(hm.size() == capacity){
                hm.remove(dummy.next.key) ;
                remove(dummy.next) ;
                Node node = new Node(key,value) ;
                insertAtTail(node) ;
                hm.put(key,node) ;
            }
            else{
                Node node = new Node(key,value) ;
                insertAtTail(node) ;
                hm.put(key,node) ;
            }
        }
    }
    public void remove(Node node){
        node.prev.next = node.next ;
        node.next.prev = node.prev ;
    }
    public void insertAtTail(Node node){
        node.next = tail ;
        node.prev = tail.prev ;
        tail.prev.next = node ;
        tail.prev = node ;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */