public class Main {
    public static void main(String[] args) {
                // Testing MyArrayList
                MyList<Integer> arrayList = new MyArrayList<>();
                arrayList.add(9);
                arrayList.add(6);
                arrayList.addFirst(3);
                System.out.println("ArrayList: " + arrayList.toArray()[0] + ", " + arrayList.toArray()[1] + ", " + arrayList.toArray()[2]);

                // Testing MyLinkedList
                MyList<Integer> linkedList = new MyLinkedList<>();
                linkedList.add(1);
                linkedList.add(4);
                linkedList.addLast(11);
                System.out.println("LinkedList: " + linkedList.toArray()[0] + ", " + linkedList.toArray()[1] + " " + linkedList.toArray()[1]);

  }
}
