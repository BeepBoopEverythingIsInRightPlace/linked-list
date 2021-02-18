

public class DoublyLinkedList<T> {
    //"pointers"
    Node<T> frontNode;
    Node<T> backNode;

    private static class Node<G> {
        Node<G> next;
        Node<G> prev;
        G value;

        public Node(G value, Node<G> prevNode, Node<G> nextNode) {
            this.value = value;
            this.prev = prevNode;
            this.next = nextNode;
        }
    }

    public DoublyLinkedList() {
        frontNode = null;
        backNode = null;
    }

    public void push(T value) {
        Node<T> node;
        if (notEmpty()) {
            node = new Node<>(value, backNode, null);
            backNode.next = node;
        } else {
            node = new Node<>(value, null, null);
            frontNode = node;
        }
        backNode = node;

    }


    public T pop() {
        T value = backNode.value;
        if (backNode.prev != null) {
            backNode.prev.next = null;
            backNode = backNode.prev;
        } else {
            backNode = null;
            frontNode = null;
        }
        return value;
    }

    public void unshift(T value) {
        Node<T> node;
        if (notEmpty()) {
            node = new Node<>(value, null, frontNode);
            frontNode.prev = node;
        } else {
            node = new Node<>(value, null, null);
            backNode = node;
        }
        frontNode = node;
    }

    public T shift() {
        T value = frontNode.value;
        if (frontNode.next != null) {
            frontNode.next.prev = null;
            frontNode = frontNode.next;
        } else {
            backNode = null;
            frontNode = null;
        }
        return value;
    }

    private boolean notEmpty() {
        return backNode != null && frontNode != null;
    }
}
