package demo;

/**
 * https://segmentfault.com/a/1190000040336213
 * https://blog.csdn.net/Krone_/article/details/125053241
 */
public class MyHashMap {

    static class Node {
        int key, value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int CAPACITY = 10000;
    Node[] nodes = new Node[CAPACITY];

    public void put(int key, int value) {
        int idx = getIndex(key);
        Node now = nodes[idx], tmp = now;
        if (tmp != null) {
            Node prev = null;
            while (tmp != null) {
                if (tmp.key == key) {
                    tmp.value = value;
                    return;
                }
                prev = tmp;
                tmp = tmp.next;
            }
            tmp = prev;
        }

        Node node = new Node(key, value);
        if (tmp != null) {
            tmp.next = node;
        } else {
            nodes[idx] = node;
        }
    }

    public int get(int key) {
        int idx = getIndex(key);
        Node now = nodes[idx];

        if (now != null) {
            if (now.key == key) {
                return now.value;
            } else {
                while (now != null) {
                    if (now.key == key) {
                        return now.value;
                    }
                    now = now.next;
                }
            }
        }

        return -1;
    }

    public void remove(int key) {
        int idx = getIndex(key);
        Node now = nodes[idx];

        if (now != null) {
            Node prev = null;
            while (now != null) {
                if (now.key == key) {
                    if (prev != null) {
                        prev.next = now.next;
                    }else {
                        nodes[idx] = now.next;
                    }
                    now.next = null;
                    return;
                }
                prev = now;
                now = now.next;
            }
        }
    }

    private int getIndex(int key) {
        int hash = Integer.hashCode(key);
        hash ^= (hash >>> 16);
        return hash % CAPACITY;
    }

    private void resize(int newCapacity) {
        Node[] oldTable = nodes;
        nodes = new Node[newCapacity];

        for(Node node : oldTable) {
            while(node != null) {
                Node next = node.next;
                int idx = getIndex(node.key);
                node.next = nodes[idx];
                nodes[idx] = node;
                node = next;
            }
        }
        // update threshold = (int) (newCapacity*loadFactor)
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 1);
        map.put(2, 2);
        map.put(1, 40);
        map.put(2, 200);

        System.out.println(map.get(1));
        System.out.println(map.get(2));
    }

}
