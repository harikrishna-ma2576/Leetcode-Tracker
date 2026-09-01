// Last updated: 01/09/2026, 12:25:01
1class LRUCache extends LinkedHashMap<Integer, Integer> {
2    private int capacity;
3
4    public LRUCache(int capacity) {
5        super(capacity, 0.75f, true);
6        this.capacity = capacity;
7    }
8
9    public int get(int key) {
10        return super.getOrDefault(key, -1);
11    }
12
13    public void put(int key, int value) {
14        super.put(key, value);
15
16        if (size() > capacity) {
17            removeEldestEntry();
18        }
19    }
20
21    private void removeEldestEntry() {
22        Integer firstKey = keySet().iterator().next();
23        remove(firstKey);
24    }
25}