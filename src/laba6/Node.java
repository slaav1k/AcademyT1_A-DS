package laba6;

class Node<KEY, VALUE> {
    KEY key;
    VALUE value;
    Node<KEY, VALUE> left;
    Node<KEY, VALUE> right;

    Node(KEY key, VALUE value) {
        this.key = key;
        this.value = value;
    }

    public KEY getKey() {
        return key;
    }

    public void setKey(KEY key) {
        this.key = key;
    }

    public VALUE getValue() {
        return value;
    }

    public void setValue(VALUE value) {
        this.value = value;
    }

    public Node<KEY, VALUE> getLeft() {
        return left;
    }

    public void setLeft(Node<KEY, VALUE> left) {
        this.left = left;
    }

    public Node<KEY, VALUE> getRight() {
        return right;
    }

    public void setRight(Node<KEY, VALUE> right) {
        this.right = right;
    }
}
