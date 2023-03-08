//package demo;
//
//public class MyHashMap<K, V> implements IMyHashMap {
//
//    static class Node {
//        int key, value;
//        Node next;
//
//        public Node(int key, int value) {
//            this.key = key;
//            this.value = value;
//        }
//    }
//
//    private final int CAPACITY = 10000;
//    Node[] nodes = new Node[CAPACITY];
//
//    public void put(int key, int value) {
//        int idx = getIndex(key);
//        Node now = nodes[idx], tmp = now;
//        if (tmp != null) {
//            Node prev = null;
//            while (tmp != null) {
//                if (tmp.key == key) {
//                    tmp.value = value;
//                    return;
//                }
//                prev = tmp;
//                tmp = tmp.next;
//            }
//            tmp = prev;
//        }
//
//        Node node = new Node(key, value);
//        if (tmp != null) {
//            tmp.next = node;
//        } else {
//            nodes[idx] = node;
//        }
//    }
//
//    public int get(int key) {
//        int idx = getIndex(key);
//        Node now = nodes[idx];
//
//        if (now != null) {
//            if (now.key == key) {
//                return now.value;
//            } else {
//                while (now != null) {
//                    if (now.key == key) {
//                        return now.value;
//                    }
//                    now = now.next;
//                }
//            }
//        }
//
//        return -1;
//    }
//
//    public void remove(int key) {
//        int idx = getIndex(key);
//        Node now = nodes[idx];
//
//        if (now != null) {
//            Node prev = null;
//            while (now != null) {
//                if (now.key == key) {
//                    if (prev != null) {
//                        prev.next = now.next;
//                    }else {
//                        nodes[idx] = now.next;
//                    }
//                    now.next = null;
//                    return;
//                }
//                prev = now;
//                now = now.next;
//            }
//        }
//    }
//
//    private int getIndex(int key) {
//        int hash = Integer.hashCode(key);
//        hash ^= (hash >>> 16);
//        return hash % CAPACITY;
//    }
//
//}
