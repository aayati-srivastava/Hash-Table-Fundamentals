import java.util.*;

public class Problem10 {

    public static void main(String[] args) {

        // ---------- CACHE LEVELS ----------
        LinkedHashMap<String,String> L1 =
                new LinkedHashMap<>(10000,0.75f,true);
        HashMap<String,String> L2 = new HashMap<>();
        HashMap<String,String> L3 = new HashMap<>();
        HashMap<String,Integer> access = new HashMap<>();

        int L1hit=0,L2hit=0,L3hit=0;

        // ---------- DATABASE ----------
        L3.put("video1","DATA1");
        L3.put("video2","DATA2");
        L3.put("video3","DATA3");

        // ---------- REQUEST FUNCTION ----------
        String video = "video1";

        if(L1.containsKey(video)){
            L1hit++;
            System.out.println("L1 HIT (0.5ms)");
        }
        else if(L2.containsKey(video)){
            L2hit++;
            System.out.println("L2 HIT (5ms)");

            L1.put(video,L2.get(video)); // promote to L1
        }
        else{
            L3hit++;
            System.out.println("L3 HIT (150ms)");

            String data = L3.get(video);
            L2.put(video,data); // add to L2
        }

        // ---------- SECOND REQUEST ----------
        if(L1.containsKey(video)){
            L1hit++;
            System.out.println("Second request → L1 HIT");
        }

        // ---------- ACCESS COUNT ----------
        access.put(video, access.getOrDefault(video,0)+1);

        // ---------- STATS ----------
        int total = L1hit+L2hit+L3hit;

        System.out.println("\nStatistics:");
        System.out.println("L1 Hits: "+L1hit);
        System.out.println("L2 Hits: "+L2hit);
        System.out.println("L3 Hits: "+L3hit);
        System.out.println("Total Requests: "+total);
    }
}