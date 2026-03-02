import java.util.*;

public class Problem3 {

    static class Entry {
        String ip;
        long expiry;

        Entry(String ip, int ttl) {
            this.ip = ip;
            this.expiry = System.currentTimeMillis() + ttl * 1000;
        }

        boolean expired() {
            return System.currentTimeMillis() > expiry;
        }
    }

    static HashMap<String, Entry> cache = new HashMap<>();
    static int hits = 0, misses = 0;

    static String resolve(String domain, int ttl) {

        if (cache.containsKey(domain)) {
            Entry e = cache.get(domain);

            if (!e.expired()) {
                hits++;
                return "HIT → " + e.ip;
            } else {
                cache.remove(domain);
            }
        }

        misses++;
        String ip = "192.168.0." + new Random().nextInt(255);
        cache.put(domain, new Entry(ip, ttl));

        return "MISS → " + ip;
    }

    public static void main(String[] args) throws Exception {

        System.out.println(resolve("google.com", 3));
        System.out.println(resolve("google.com", 3));

        Thread.sleep(4000);

        System.out.println(resolve("google.com", 3));

        System.out.println("Hits: " + hits + " Misses: " + misses);
    }
}