public class Node {
    Integer key;
    Integer value;
    Node prev;
    Node next;

    Node(Integer key, Integer value, Node prev, Node next) {
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

}
