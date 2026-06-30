package cache;

public class DoublyLinkedList<K> {

    private Node<K> head;
    private Node<K> tail;

    public DoublyLinkedList() {

        head = new Node<>(null);
        tail = new Node<>(null);

        head.next = tail;
        tail.prev = head;
    }

    public void addLast(Node<K> node) {

        Node<K> prev = tail.prev;

        prev.next = node;
        node.prev = prev;

        node.next = tail;
        tail.prev = node;
    }

    public void remove(Node<K> node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public Node<K> removeFirst() {

        if (isEmpty()) {
            return null;
        }

        Node<K> node = head.next;

        remove(node);

        return node;
    }

    public boolean isEmpty() {
        return head.next == tail;
    }


}