package demo;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private int capacity;
    private Map<Integer, Integer> cache;
    private Map<Integer, Integer> accessOrder;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<Integer, Integer>((int) (capacity / 0.75) + 1, 0.75f, true);
        this.accessOrder = new LinkedHashMap<Integer, Integer>((int) (capacity / 0.75) + 1, 0.75f, true);
        //this.cache = new LinkedHashMap<>();
        //this.accessOrder = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            // 将访问的元素移到链表头部
            //accessOrder.remove(key);
            //accessOrder.put(key, key);
            return cache.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // 更新值并将元素移到链表头部
            cache.put(key, value);
            //accessOrder.remove(key);
            //accessOrder.put(key, key);
        } else {
            // 如果缓存已满，淘汰最久未使用的元素
            if (cache.size() >= capacity) {
                int leastRecentKey = cache.entrySet().iterator().next().getKey();
                cache.remove(leastRecentKey);
                //accessOrder.remove(leastRecentKey);
            }
            cache.put(key, value);
            //accessOrder.put(key, key);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 10);
        cache.put(2, 20);
        System.out.println(cache.get(1));  // 输出: 10

        cache.put(3, 30);
        System.out.println(cache.get(2));  // 输出: -1

        cache.put(4, 40);
        System.out.println(cache.get(1));  // 输出: -1
        System.out.println(cache.get(3));


        LinkedHashMap map = new LinkedHashMap(4, 0.8f, true);
        map.put("222", 222);
        map.put("111", 111);
        map.put("333", 333);

        map.get("333");
        map.get("111");
        map.get("222");
        map.put("444", 444);

        System.out.println("遍历迭代器：");
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("遍历map：");
        map.forEach((k,v) -> {
            System.out.println(k + ": " + v);
        });
    }
}
