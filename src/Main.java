import java.util.Arrays;

public class Main {

    // Linear Search Method
    public static boolean searchBogie(String[] bogieIds, String searchId) {
        for (String id : bogieIds) {
            if (id.equalsIgnoreCase(searchId)) {
                return true;
            }
        }
        return false;
    } // <--- THIS BRACE WAS MISSING

    public static void main(String[] args) {

        System.out.println("UC18 Linear Search for Bogie ID\n");

        // Create array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Bogie ID to search
        String searchId = "BG309";

        // Display all bogies
        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        // Perform search
        boolean found = searchBogie(bogieIds, searchId);

        // Display result
        if (found) {
            System.out.println("\nBogie " + searchId + " found in train consist.");
        } else {
            System.out.println("\nBogie " + searchId + " NOT found.");
        }

        System.out.println("\nUC18 search completed....");
    }
}