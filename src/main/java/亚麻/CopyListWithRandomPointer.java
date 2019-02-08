package 亚麻;


/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 */
public class CopyListWithRandomPointer {

    class Node {
        int label;
        Node next, random;
        public Node (int label) {
            this.label = label;
        }
    }

    public Node clone(Node root) {
        if (root == null) {
            return root;
        }

        Node head = root;
        while (head != null) {
            Node node = new Node(head.label);
            node.next = head.next;
            head.next = node;
            head = node.next;
        }

        head = root;

        while (head != null) {
            Node next = head.next;
            next.random = head.random != null ? head.random.next : null;
            head = head.next.next;
        }

        Node ret = new Node(-1);
        Node node = ret;
        head = root;


        while (head != null) {
            node.next = head.next;
            head.next = head.next.next;
            head = head.next;
            node = node.next;
        }

        return ret.next;
    }
}
