import java.util.*;

public class Problem2 {

    public static void main(String[] args) {

        // productId -> stock
        HashMap<String,Integer> stock = new HashMap<>();

        // waiting list (FIFO)
        LinkedHashMap<Integer,String> waitingList = new LinkedHashMap<>();


        // initial stock
        stock.put("IPHONE15_256GB",100);


        String product = "IPHONE15_256GB";


        // check stock
        System.out.println(product + " → " + stock.get(product) + " units available");


        // simulate purchases
        for(int userId=1; userId<=105; userId++) {

            // check stock
            if(stock.get(product) > 0) {

                int current = stock.get(product);
                stock.put(product, current-1);

                System.out.println("User " + userId +
                        " → Purchase Success, Remaining: " + stock.get(product));

            } else {

                waitingList.put(userId, product);

                System.out.println("User " + userId +
                        " → Added to waiting list, position #" + waitingList.size());
            }
        }



        // final stock check
        System.out.println("Final Stock: " + stock.get(product));


        // show waiting list
        System.out.println("Waiting List Users:");
        for(Integer id : waitingList.keySet())
            System.out.println(id);
    }
}