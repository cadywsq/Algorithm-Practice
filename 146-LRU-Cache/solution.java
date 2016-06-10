public class LRUCache {
    class Node {
        private Node pre = null;
        private Node next = null;
        private int key;
        private int val;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    private final Map<Integer, Node> cache = new HashMap<>();
    private int capacity;
    // sentinel node
    private final Node head = new Node(-1, -1);
    private final Node tail = new Node(-1, -1);
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        int value = -1;
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            moveToHead(node);
            value = node.val;
        }
        return value;
    }
    
    public void set(int key, int value) {
        Node node;
        if (!cache.containsKey(key)) {
            node = new Node(key, value);
            setHead(node);
        } else {
            node = cache.get(key);
            node.val = value;
            moveToHead(node);
        }
        cache.put(key, node);
        
        if (cache.size() > capacity) {
            cache.remove(tail.pre.key);
            remove(tail.pre);
        }
    }
    
    private void moveToHead(Node node) {
        remove(node);
        setHead(node);
    }
    
    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    private void setHead(Node node) {
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }
}