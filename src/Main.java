import java.util.Arrays;

public class Main {

    // You must define the method that you are calling in main!
    public static boolean binarySearch(String[] arr, String key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Compare the middle element with the key
            int result = key.compareTo(arr[mid]);

            // Check if key is present at mid
            if (result == 0) {
                return true;
            }

            // If key is greater, ignore left half
            if (result > 0) {
                low = mid + 1;
            }
            // If key is smaller, ignore right half
            else {
                high = mid - 1;
            }
        }
        return false; // Not found
    }

    public static void main(String[] args) {

        System.out.println("\nUC19 Binary Search for Bogie ID\n");

        // Create array
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Search key
        String key = "BG309";

        // IMPORTANT: Binary Search ONLY works on sorted arrays
        Arrays.sort(bogieIds);

        // Display
        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        // Now this call will work because we defined the method above
        boolean found = binarySearch(bogieIds, key);

        // Result
        if (found) {
            System.out.println("\nBogie " + key + " found using Binary Search.");
        } else {
            System.out.println("\nBogie " + key + " NOT found.");
        }

        System.out.println("\nUC19 search completed....");
    }
}