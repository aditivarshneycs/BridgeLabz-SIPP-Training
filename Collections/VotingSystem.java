import java.util.*;

public class VotingSystem {
    public static void main(String[] args) {
        // HashMap to store votes
        HashMap<String, Integer> voteMap = new HashMap<>();
        voteMap.put("Alice", 5);
        voteMap.put("Bob", 3);
        voteMap.put("Charlie", 7);

        // Display in insertion order
        LinkedHashMap<String, Integer> linkedVotes = new LinkedHashMap<>();
        linkedVotes.put("Alice", 5);
        linkedVotes.put("Bob", 3);
        linkedVotes.put("Charlie", 7);

        // Display in sorted order
        TreeMap<String, Integer> sortedVotes = new TreeMap<>(voteMap);

        System.out.println("Vote Count (HashMap): " + voteMap);
        System.out.println("Insertion Order (LinkedHashMap): " + linkedVotes);
        System.out.println("Sorted Order (TreeMap): " + sortedVotes);
    }
}