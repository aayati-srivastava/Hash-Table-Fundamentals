import java.util.*;

public class Problem5 {

    public static void main(String[] args) {

        // HashMaps for analytics
        HashMap<String, Integer> pageViews = new HashMap<>();
        HashMap<String, HashSet<String>> uniqueVisitors = new HashMap<>();
        HashMap<String, Integer> sources = new HashMap<>();

        // ---- Simulated incoming events ----
        processEvent("/article/breaking-news", "user1", "google", pageViews, uniqueVisitors, sources);
        processEvent("/article/breaking-news", "user2", "facebook", pageViews, uniqueVisitors, sources);
        processEvent("/sports/final", "user1", "direct", pageViews, uniqueVisitors, sources);
        processEvent("/article/breaking-news", "user1", "google", pageViews, uniqueVisitors, sources);
        processEvent("/sports/final", "user3", "google", pageViews, uniqueVisitors, sources);

        // ---- Dashboard ----
        System.out.println("=== DASHBOARD ===");

        // Top Pages (sorted)
        List<Map.Entry<String,Integer>> list = new ArrayList<>(pageViews.entrySet());
        list.sort((a,b) -> b.getValue() - a.getValue());

        System.out.println("Top Pages:");
        for(Map.Entry<String,Integer> e : list){
            String page = e.getKey();
            int views = e.getValue();
            int unique = uniqueVisitors.get(page).size();

            System.out.println(page + " - " + views + " views (" + unique + " unique)");
        }

        // Traffic Sources
        System.out.println("\nTraffic Sources:");
        for(String s : sources.keySet()){
            System.out.println(s + " : " + sources.get(s));
        }
    }

    // Event processor
    static void processEvent(String url, String user, String source,
                             HashMap<String,Integer> pageViews,
                             HashMap<String,HashSet<String>> uniqueVisitors,
                             HashMap<String,Integer> sources){

        // count page views
        pageViews.put(url, pageViews.getOrDefault(url,0)+1);

        // track unique visitors
        uniqueVisitors.putIfAbsent(url, new HashSet<>());
        uniqueVisitors.get(url).add(user);

        // track sources
        sources.put(source, sources.getOrDefault(source,0)+1);
    }
}