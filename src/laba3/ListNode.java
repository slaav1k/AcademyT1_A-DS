package laba3;

class ListNode<T> implements ItemOfList<T> {
    T data;
    ListNode<T> next;
    ListNode<T> prev;

    ListNode(T data) {
        this.data = data;
    }

    @Override
    public T get() {
        return data;
    }
}
