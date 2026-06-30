package cache;

class Node<K> {

        K key;

        int frequency;

        Node<K> prev;
        Node<K> next;

        public Node(K key) {
            this.key = key;
            this.frequency = 1;
        }
    }