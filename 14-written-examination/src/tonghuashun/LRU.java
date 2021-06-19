package tonghuashun;


import java.util.LinkedHashMap;

public class LRU<K, V>  extends LinkedHashMap<K, V> {
    private int capacity ;

    public LRU(int capacity) {
        super(256, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        if(size() > capacity){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        LRU<String, Integer> lru = new LRU<>(5);
        for(int i = 0; i < 10; i++){
            lru.put(i+"",i);
            System.out.println("=========");
            lru.forEach((k,v)->{
                System.out.println(v);
            });
        }
    }
}