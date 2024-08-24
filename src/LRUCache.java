import java.util.HashMap;

public class LRUCache {
    public static HashMap<Integer, Node> nodeMap = new HashMap<>();
    private Integer capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(0, 0, null, null);
        this.tail = new Node(0, 0, null, null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public Integer get(Integer key){
        if(nodeMap.containsKey(key)){
            Node foundNode = nodeMap.get(key);
            deleteNode(foundNode);
            Node insertedNode = insertNodeAfterHead(key, foundNode.value);
            nodeMap.put(key, insertedNode);
            return foundNode.value;
        }
        return -1;
    }

    private Node insertNodeAfterHead(Integer key, Integer value) {
        Node nextNode = this.head.next;
        Node newNode = new Node(key, value, head, nextNode);
        this.head.next = newNode;
        nextNode.prev = newNode;  
//        newNode.prev = this.head;
//        newNode.next = nextNode;
        return newNode;
    }

    private void deleteNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void put(Integer key, Integer value){
        if(nodeMap.containsKey(key)){
            deleteNode(nodeMap.get(key));
        }else{
            if(nodeMap.size() >= this.capacity){
                System.out.println(capacity+" "+nodeMap.size());
                deleteLeastRecentlyUsed();
            }
        }
        Node insertedNode = insertNodeAfterHead(key, value);
        nodeMap.put(key, insertedNode);
        System.out.println("inserted value "+insertedNode.value+"to key "+key);
    }

    private void deleteLeastRecentlyUsed(){
        Node lrusedNode = this.tail.prev;
        this.tail.prev = lrusedNode.prev;
        Node prevNode = lrusedNode.prev;
        prevNode.next = lrusedNode.next;
        nodeMap.remove(lrusedNode.key);
    }


}
