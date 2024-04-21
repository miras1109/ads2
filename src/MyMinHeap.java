class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    public T removeMin() {
        if (isEmpty())
            throw new IllegalStateException("Heap is empty");
        T min = heap.get(0);
        T lastItem = heap.get(heap.size() - 1);
        heap.set(0, lastItem);
        heap.remove(heap.size() - 1);
        heapifyDown(0);
        return min;
    }

    public T peekMin() {
        if (isEmpty())
            throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }
    public void insert(T item) {
        heap.add(item);
        heapifyUp(heap.size() - 1);
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
                swapHeap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallestIndex = index;
        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(smallestIndex)) < 0) {
            smallestIndex = leftChildIndex;
        }
        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(smallestIndex)) < 0) {
            smallestIndex = rightChildIndex;
        }
        if (smallestIndex != index) {
            swapHeap(index, smallestIndex);
            heapifyDown(smallestIndex);
        }
    }

    private void swapHeap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    public boolean isEmpty() {
        return heap.size() == 0;
    }
}
