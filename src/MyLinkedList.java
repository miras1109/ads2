import java.util.Iterator;

class MyLinkedList<T> implements MyList<T> {
    private class MyNode {
        T element;
        MyNode next;
        MyNode prev;

        MyNode(T element, MyNode prev, MyNode next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        MyNode node = getNode(index);
        node.element = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (index == size) {
            addLast(item);
            return;
        }
        MyNode current = getNode(index);
        MyNode newNode = new MyNode(item, current.prev, current);
        if (current.prev != null)
            current.prev.next = newNode;
        else
            head = newNode;
        current.prev = newNode;
        size++;
    }

    @Override
    public void addFirst(T item) {
        if (isEmpty()) {
            head = new MyNode(item, null, null);
            tail = head;
        } else {
            MyNode newNode = new MyNode(item, null, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        if (isEmpty()) {
            head = new MyNode(item, null, null);
            tail = head;
        } else {
            MyNode newNode = new MyNode(item, tail, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        return getNode(index).element;
    }

    @Override
    public T getFirst() {
        if (isEmpty())
            throw new IllegalStateException("List is empty");
        return head.element;
    }

    @Override
    public T getLast() {
        if (isEmpty())
            throw new IllegalStateException("List is empty");
        return tail.element;
    }

    @Override
    public void remove(int index) {
        MyNode node = getNode(index);
        removeNode(node);
    }

    @Override
    public void removeFirst() {
        if (isEmpty())
            throw new IllegalStateException("List is empty");
        removeNode(head);
    }

    @Override
    public void removeLast() {
        if (isEmpty())
            throw new IllegalStateException("List is empty");
        removeNode(tail);
    }

    @Override
    public void sort() {
    }

    @Override
    public int indexOf(Object object) {
        MyNode current = head;
        int index = 0;
        while (current != null) {
            if (current.element.equals(object))
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.element.equals(object))
                return index;
            current = current.prev;
            index--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        MyNode current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.element;
            current = current.next;
        }
        return array;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private MyNode getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private void removeNode(MyNode node) {
        if (node.prev != null)
            node.prev.next = node.next;
        else
            head = node.next;
        if (node.next != null)
            node.next.prev = node.prev;
        else
            tail = node.prev;
        size--;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext())
                    throw new IllegalStateException();
                T item = current.element;
                current = current.next;
                return item;
            }
        };
    }
}
