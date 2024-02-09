package Seminar_4;

public class Main {
    public static void main(String[] args) {

        class MyHashMap<K, V> {
            Node<K, V>[] arr;
            private int size = 0;

            @SuppressWarnings("unused")
            static final int HASH_MAP_SIZE = 16;

            @SuppressWarnings({ "unused", "unchecked" })
            public MyHashMap() {
                arr = new Node[16];
            }

            @SuppressWarnings("unchecked")
            public MyHashMap(int size) {
                arr = new Node[size];
            }

            public Object put(K key, V value) {
                Node<K, V> tmp = new Node<>(key, value, key.hashCode());
                int i = Math.abs(key.hashCode()) % arr.length;
                V ret = null;
                if (arr[i] == null) {
                    size++;
                    arr[i] = tmp;
                    return null;
                }
                ret = arr[i].getValue();
                arr[i] = tmp;
                return ret;
            }

            public V get(Object key) {
                int i = Math.abs(key.hashCode()) % arr.length;
                if (arr[i] != null)
                    return arr[i].getValue();
                return null;
            }

            public V remove(Object key) {
                int i = Math.abs(key.hashCode()) % arr.length;
                if (arr[i] == null)
                    return null;
                size--;
                V tmp = arr[i].value;
                arr[i] = null;
                return tmp;
            }

            @SuppressWarnings("hiding")
            class Node<K, Y> {
                public V value;
                @SuppressWarnings("unused")
                K key;
                @SuppressWarnings("unused")
                final int hash;

                public Node(K key, V value, int hash) {
                    this.key = key;
                    this.value = value;
                    this.hash = hash;
                }

                public V getValue() {
                    return value;
                }

                @SuppressWarnings("unused")
                public int getSize() {
                    return size;
                }
            }

        }

        MyHashMap<Integer, String> myHashMap = new MyHashMap<>(5);
        System.out.println(myHashMap.put(2, "hi"));
        System.out.println(myHashMap.put(2, "bye"));
        System.out.println(myHashMap.put(2, "hello"));
        System.out.println(myHashMap.get(2));
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.remove(2));
        System.out.println(myHashMap.remove(1));
    }
}
