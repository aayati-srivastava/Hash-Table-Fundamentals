import java.util.*;

public class Problem1 {

    public static void main(String[] args) {

        // username -> userId
        HashMap<String,Integer> users = new HashMap<>();

        // username -> attempt count
        HashMap<String,Integer> attempts = new HashMap<>();


        // existing users
        users.put("john_doe",101);
        users.put("alice",102);
        users.put("admin",103);


        String username = "john_doe";

        // track attempts
        attempts.put(username, attempts.getOrDefault(username,0)+1);


        // check availability
        if(users.containsKey(username))
            System.out.println(username + " → Not Available");
        else
            System.out.println(username + " → Available");



        // suggestions if taken
        if(users.containsKey(username)) {

            System.out.println("Suggestions:");

            for(int i=1;i<=3;i++) {
                String suggestion = username + i;
                if(!users.containsKey(suggestion))
                    System.out.println(suggestion);
            }

            String dot = username.replace("_",".");
            if(!users.containsKey(dot))
                System.out.println(dot);
        }



        // simulate multiple attempts
        for(int i=0;i<5;i++)
            attempts.put("admin", attempts.getOrDefault("admin",0)+1);



        // most attempted username
        String maxUser = "";
        int max = 0;

        for(String key : attempts.keySet()) {
            if(attempts.get(key) > max) {
                max = attempts.get(key);
                maxUser = key;
            }
        }

        System.out.println("Most attempted: " + maxUser + " (" + max + " attempts)");
    }
}