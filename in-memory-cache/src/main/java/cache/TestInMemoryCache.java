package cache;

public class TestInMemoryCache {

    public static void main(String args[]) throws InterruptedException {

        EvictionPolicy<String> evictionPolicy = new LRUEvictionPolicy<>();

        InMemoryCache<String, String> in = new InMemoryCacheImpl<>(evictionPolicy, 1);

        in.put("AI", "LLM", 30000L);

        System.out.println(in.get("AI"));

        Thread.sleep(30000L);

        System.out.println(in.get("AI"));

    }
}
