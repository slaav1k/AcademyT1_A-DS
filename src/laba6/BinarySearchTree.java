package laba6;

public class BinarySearchTree<KEY extends Comparable<KEY>, VALUE> {
    private Node<KEY, VALUE> root;

    public VALUE get(KEY key) {
        Node<KEY, VALUE> cur = root;
        while (cur != null) {
            int cmp = key.compareTo(cur.getKey());
            if (cmp == 0) {
                return cur.getValue();
            } else if (cmp < 0) {
                cur = cur.getLeft();
            } else {
                cur = cur.getRight();
            }
        }
        return null;
    }

    public void add(KEY key, VALUE value) {
        if (root == null) {
            root = new Node<>(key, value);
            return;
        }

        Node<KEY, VALUE> cur = root;
        Node<KEY, VALUE> parent = null;

        while (cur != null) {
            parent = cur;
            int cmp = key.compareTo(cur.getKey());

            if (cmp == 0) {
                // ключ есть, обновляем значение
                cur.setValue(value);
                return;
            } else if (cmp < 0) {
                cur = cur.getLeft();
            } else {
                cur = cur.getRight();
            }
        }

        // добавляем новый узел
        Node<KEY, VALUE> newNode = new Node<>(key, value);
        if (key.compareTo(parent.getKey()) < 0) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }
    }

    public VALUE remove(KEY key) {
        if (root == null) {
            return null;
        }

        Node<KEY, VALUE> cur = root;
        Node<KEY, VALUE> parent = null;
        boolean isLeftChild = true;

        // ищем узел
        while (cur != null) {
            int cmp = key.compareTo(cur.getKey());
            if (cmp == 0) {
                break;
            }
            parent = cur;
            if (cmp < 0) {
                isLeftChild = true;
                cur = cur.getLeft();
            } else {
                isLeftChild = false;
                cur = cur.getRight();
            }
        }

        // не нашли
        if (cur == null) {
            return null;
        }

        VALUE removedValue = cur.getValue();

        // нет потомков? удаляем узел
        if (cur.getLeft() == null && cur.getRight() == null) {
            if (cur == root) { // узел корень? очищаем деерво
                root = null;
            } else if (isLeftChild) { // иначе отрываем узел
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        }
        // узел заменяем левым отростком, если нет правого
        else if (cur.getRight() == null) {
            if (cur == root) {
                root = cur.getLeft();
            } else if (isLeftChild) {
                parent.setLeft(cur.getLeft());
            } else {
                parent.setRight(cur.getLeft());
            }
        }
        // узел заменяем правым отростком, если нет левого
        else if (cur.getLeft() == null) {
            if (cur == root) {
                root = cur.getRight();
            } else if (isLeftChild) {
                parent.setLeft(cur.getRight());
            } else {
                parent.setRight(cur.getRight());
            }
        }
        // если есть оба, определяем преемника
        else {
            // находим преемника (самый левый узел в правом поддереве)
            Node<KEY, VALUE> heirParent = cur;
            Node<KEY, VALUE> heir = cur.getRight();

            while (heir.getLeft() != null) {
                heirParent = heir;
                heir = heir.getLeft();
            }

            // копируем данные преемника в удаляемый узел
            cur.setKey(heir.getKey());
            cur.setValue(heir.getValue());

            // удаляем самого преемника
            if (heirParent == cur) {
                // преемник - правый
                heirParent.setRight(heir.getRight());
            } else {
                heirParent.setLeft(heir.getRight());
            }
        }

        return removedValue;
    }

}