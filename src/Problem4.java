import java.util.*;

public class Problem4 {

    public static void main(String[] args) {

        String doc1 = "this is a sample student essay for plagiarism detection";
        String doc2 = "this is a sample essay written for plagiarism checking";

        int n = 3; // n-gram size

        // Convert docs to n-grams
        Set<String> grams1 = getNGrams(doc1, n);
        Set<String> grams2 = getNGrams(doc2, n);

        // Store n-grams in hash map (gram → documents)
        HashMap<String, Set<String>> map = new HashMap<>();

        addToMap(map, grams1, "Doc1");
        addToMap(map, grams2, "Doc2");

        // Count matches
        int match = 0;
        for(String g : grams1) {
            if(grams2.contains(g))
                match++;
        }

        // Similarity %
        double similarity = (double)match / grams1.size() * 100;

        System.out.println("Matching n-grams: " + match);
        System.out.println("Similarity: " + similarity + "%");

        if(similarity > 50)
            System.out.println("PLAGIARISM DETECTED");
        else
            System.out.println("No plagiarism");
    }

    // Create n-grams
    static Set<String> getNGrams(String text, int n) {
        String[] words = text.split(" ");
        Set<String> set = new HashSet<>();

        for(int i = 0; i <= words.length - n; i++) {
            String gram = "";
            for(int j = 0; j < n; j++)
                gram += words[i+j] + " ";
            set.add(gram.trim());
        }
        return set;
    }

    // Store grams in HashMap
    static void addToMap(HashMap<String, Set<String>> map, Set<String> grams, String doc) {
        for(String g : grams) {
            map.putIfAbsent(g, new HashSet<>());
            map.get(g).add(doc);
        }
    }
}