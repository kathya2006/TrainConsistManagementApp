import java.util.Arrays;

public class Main {

    // Method to sort bogie names
    public static void sortBogieNames(String[] bogies) {
        Arrays.sort(bogies);
    }

    public static void main(String[] args) {

        System.out.println("UC17 Sort Bogie Names Using Arrays.sort()\n");

        // Original array
        String[] bogies = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        // Display original
        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogies));

        // Sort
        sortBogieNames(bogies);

        // Display sorted
        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogies));

        System.out.println("\nUC17 sorting completed....");
    }
}