import java.util.*;

public class Problem7 {

    public static void main(String[] args) {

        // Store search queries with frequency
        HashMap<String, Integer> map = new HashMap<>();

        // Sample existing queries
        map.put("java tutorial", 120);
        map.put("javascript basics", 95);
        map.put("java download", 80);
        map.put("java 21 features", 60);
        map.put("java interview questions", 70);
        map.put("python tutorial", 110);

        String prefix = "jav";

        // Find matching queries
        ArrayList<String> matches = new ArrayList<>();

        for(String key : map.keySet()) {
            if(key.startsWith(prefix))
                matches.add(key);
        }

        // Sort by frequency (highest first)
        matches.sort((a,b) -> map.get(b) - map.get(a));

        // Display top suggestions
        System.out.println("Suggestions:");
        int count = 0;

        for(String s : matches) {
            System.out.println(s + " (" + map.get(s) + ")");
            count++;
            if(count == 10) break;
        }

        // Simulate new search update
        String newSearch = "java 21 features";
        map.put(newSearch, map.getOrDefault(newSearch,0)+1);

        System.out.println("\nUpdated Frequency:");
        System.out.println(newSearch + " -> " + map.get(newSearch));
    }
}