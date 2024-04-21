class MyStack<T> {
    private MyLinkedList<T> list;

    public MyStack() {
        list = new MyLinkedList<>();
    }

    public void push(T item) {
        list.addFirst(item);
    }

    public T pop() {
        if (isEmpty())
            throw new IllegalStateException("Stack is empty");
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    public T peek() {
        if (isEmpty())
            throw new IllegalStateException("Stack is empty");
        return list.getFirst();
    }
    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }


}