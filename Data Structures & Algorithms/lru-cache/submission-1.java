class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head;
    Node tail;
    Map<Integer, Node> cache;
    int capacity;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        
        Node node = cache.get(key);
        removeNode(node);
        moveToHead(node);
        
        return node.val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            removeNode(node);
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            moveToHead(newNode);

            if (cache.size() > capacity) {
                cache.remove(tail.key);
                removeNode(tail);
            }
        }
    }

    private void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next; 
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev; 
        }
    }

    private void moveToHead(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }
        
        head = node; 

        if (tail == null) {
            tail = node; 
        }
    }
}