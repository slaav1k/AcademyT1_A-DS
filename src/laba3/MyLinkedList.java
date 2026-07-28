package laba3;

import java.util.Objects;

public class MyLinkedList<T> {

    private ListNode<T> head;
    private ListNode<T> tail;
    private int totalElements = 0;

    public ItemOfList<T> pushFront(T pValue) {
        ListNode<T> newNode = new ListNode<>(pValue);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        totalElements++;
        return newNode;
    }


    public ItemOfList<T> pushBack(T pValue) {
        if (head == null) {
            return pushFront(pValue);
        }
        ListNode<T> newNode = new ListNode<>(pValue);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        totalElements++;
        return newNode;
    }


    public ItemOfList<T> insertAfter(ItemOfList<T> pItemOfList, T pValue) {
        if (pItemOfList == null) throw new IllegalArgumentException("Позиция пуста");

        ListNode<T> target = (ListNode<T>) pItemOfList;

        if (target == tail) {
            return pushBack(pValue);
        }

        ListNode<T> newNode = new ListNode<>(pValue);

        newNode.next = target.next;
        newNode.prev = target;

        target.next.prev = newNode;
        target.next = newNode;

        totalElements++;
        return newNode;
    }


    public boolean contains(T pValue) {
        return findItem(pValue) != null;
    }


    public ItemOfList<T> findItem(T pValue) {
        ListNode<T> current = head;
        while (current != null) {
            if (Objects.equals(current.data, pValue)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }


    public int findIndex(T pValue) {
        ListNode<T> current = head;
        int idx = 0;
        while (current != null) {
            if (Objects.equals(current.data, pValue)) {
                return idx;
            }
            current = current.next;
            idx++;
        }
        return -1;
    }


    public void popFront() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        totalElements--;
    }


    public void popBack() {
        if (tail == null) return;
        if (head == tail) {
            popFront();
            return;
        }
        tail = tail.prev;
        tail.next = null;
        totalElements--;
    }


    public void removeAt(ItemOfList<T> pItemOfList) {
        if (pItemOfList == null) throw new IllegalArgumentException("Позиция пуста");
        ListNode<T> target = (ListNode<T>) pItemOfList;

        if (target == head) {
            popFront();
            return;
        }
        if (target == tail) {
            popBack();
            return;
        }

        target.prev.next = target.next;
        target.next.prev = target.prev;
        totalElements--;
    }


    public T getValue(ItemOfList<T> pItemOfList) {
        if (pItemOfList == null) throw new IllegalArgumentException("Позиция пуста");
        return pItemOfList.get();
    }


    public void update(ItemOfList<T> pItemOfList, T pValue) {
        if (pItemOfList == null) throw new IllegalArgumentException("Позиция пуста");
        ListNode<T> target = (ListNode<T>) pItemOfList;
        target.data = pValue;
    }


    public int size() {
        return totalElements;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        ListNode<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }
}
