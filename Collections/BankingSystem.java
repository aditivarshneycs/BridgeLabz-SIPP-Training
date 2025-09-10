import java.util.*;

public class BankingSystem {
    public static void main(String[] args) {
        HashMap<String, Integer> accounts = new HashMap<>();
        accounts.put("ACC001", 5000);
        accounts.put("ACC002", 7000);
        accounts.put("ACC003", 3000);

        TreeMap<Integer, List<String>> sortedByBalance = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : accounts.entrySet()) {
            sortedByBalance.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }

        Queue<String> withdrawalQueue = new LinkedList<>();
        withdrawalQueue.add("ACC002");
        withdrawalQueue.add("ACC001");

        System.out.println("Processing Withdrawals:");
        while (!withdrawalQueue.isEmpty()) {
            String acc = withdrawalQueue.poll();
            System.out.println("Processed: " + acc);
        }

        System.out.println("\nAccounts sorted by balance:");
        for (Map.Entry<Integer, List<String>> entry : sortedByBalance.entrySet()) {
            System.out.println("Balance ₹" + entry.getKey() + " → Accounts: " + entry.getValue());
        }
    }
}