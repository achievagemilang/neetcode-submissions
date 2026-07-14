class LRUCache {
    int cap;
    Map<Integer, Node> cache;
    Node head;
    Node tail;

    class Node {
        Node next;
        Node prev;
        int val, key;

        Node(int key, int val){
            this.val = val;
            this.key = key;
        }
    }

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;

        this.cache = new HashMap<>();
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node toUpdate = cache.get(key);
            removeLRU(toUpdate);
            insertLRU(toUpdate);
            return cache.get(key).val;
        }
        return -1;
    }

    void removeLRU(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    void insertLRU(Node node){
        Node next = tail;
        Node prev = tail.prev;

        next.prev = node;
        prev.next = node;
        node.prev = prev;
        node.next = next;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node toRemove = cache.get(key);
            removeLRU(toRemove);

            Node toUpdate = new Node (key, value);
            insertLRU(toUpdate);

            cache.put(key, toUpdate);
            return;
        }

        if(cache.size() == cap){
            Node toRemove = head.next;
            cache.remove(toRemove.key);
            removeLRU(toRemove);
        }

        Node newNode = new Node(key, value);
        insertLRU(newNode);
        cache.put(key, newNode);
        
    }
}
