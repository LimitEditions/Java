package Seminar_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Main<E> {

    public static void main(String[] args) {
        Main<Integer> main = new Main<>();
        main.testList();
    }

    public void testList() {
        MyList<Integer> myList = new MyList<>();

        myList.addElemFirst(3);
        myList.addElemFirst(1);
        myList.addElemLast(5);
        myList.addElemLast(2);

        System.out.println("Original List: " + myList);
        
        myList.sort(Comparator.naturalOrder());

        System.out.println("Sorted List: " + myList);

        myList.deleteElemFirst();
        myList.deleteElemLast();

        System.out.println("End List: " + myList);

    }

    @SuppressWarnings("hiding")
    class MyList<E> {
        private int size;
        private Node<E> first;
        private Node<E> last;

        public int getSize() {
            return size;
        }

        public void addElemFirst(E e) {
            size++;
            Node<E> node = new Node<>(e);
            if (first == null) {
                first = node;
                last = first;
                return;
            }
            node.next = first;
            first.previous = node;
            first = node;
        }

        @SuppressWarnings("unchecked")
        public void deleteElemFirst() {
            if (first != null) {
                first = first.next;
                if (first != null) {
                    first.previous = null;
                }
                size--;
            } else {
                throw new NoSuchElementException();
            }
        }

        public void addElemLast(E e) {
            if (first == null) {
                addElemFirst(e);
                return;
            }
            size++;
            Node<E> node = new Node<>(e);
            last.next = node;
            node.previous = last;
            last = node;
        }

        @SuppressWarnings("unchecked")
        public boolean contains(E e) {
            for (Node<E> i = first; i != null; i = i.next) {
                if (i.data.equals(e)) {
                    return true;
                }
            }
            return false;
        }

        @SuppressWarnings("unchecked")
        public void deleteElemLast() {
            if (first == null) {
                throw new NoSuchElementException();
            }
            size--;
            if (last.previous != null) {
                last.previous.next = null;
                last = last.previous;
            } else {
                first = null;
                last = null;
            }
        }

        @SuppressWarnings({ "unchecked", "rawtypes" })
        public void sort(Comparator<? super E> c) {
            if (size > 1) {
                Object[] array = new Object[size];
                Node<E> tmp = first;
                for (int i = 0; i < size; i++) {
                    array[i] = tmp.data;
                    tmp = tmp.next;
                }
                Arrays.sort(array, (Comparator) c);
        
                Node<E> current = first;
                for (int i = 0; i < size; i++) {
                    current.data = (E) array[i];
                    current = current.next;
                }
            }
        }

        @SuppressWarnings({ "unused", "unchecked" })
        private void swapNodes(Node<E> node1, Node<E> node2) {
            if (node1.previous != null) {
                node1.previous.next = node2;
            } else {
                first = node2;
            }

            if (node2.next != null) {
                node2.next.previous = node1;
            } else {
                last = node1;
            }

            Node<E> temp = node1.next;
            node1.next = node2.next;
            node2.next = temp;

            temp = node1.previous;
            node1.previous = node2.previous;
            node2.previous = temp;
        }

        @SuppressWarnings("unchecked")
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            Node<E> current = first;
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

        class Node<T> {
            public T data;
            @SuppressWarnings("rawtypes")
            public Node next;
            @SuppressWarnings("rawtypes")
            public Node previous;

            public Node(T data) {
                this.data = data;
                next = null;
                previous = null;
            }
        }
    }
}