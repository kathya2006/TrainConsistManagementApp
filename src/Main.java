import java.util.*;

public class Main{

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" UC20 - Exception Handling in Search ");
        System.out.println("======================================");

        // Create bogie array (empty train scenario)
        String[] bogieIds = {};

        // Search key
        String searchId = "BG101";

        try {
            // FAIL-FAST VALIDATION
            if (bogieIds.length == 0) {
                throw new RuntimeException("No bogies available in train. Search cannot be performed.");
            }

            // SEARCH LOGIC
            boolean found = false;

            for (String id : bogieIds) {
                if (id.equals(searchId)) {
                    found = true;
                    break;
                }
            }

            // Display result
            if (found) {
                System.out.println("Bogie " + searchId + " found.");
            } else {
                System.out.println("Bogie " + searchId + " NOT found.");
            }

        } catch (RuntimeException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("\nUC20 execution completed...");
    }
}