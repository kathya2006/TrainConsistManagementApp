import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] arr = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        Main.sortBogieNames(arr);
        assertArrayEquals(
                new String[]{"AC Chair", "First Class", "General", "Luxury", "Sleeper"},
                arr
        );
    }

    @Test
    void testSort_UnsortedInput() {
        String[] arr = {"Luxury", "General", "Sleeper"};
        Main.sortBogieNames(arr);
        assertArrayEquals(
                new String[]{"General", "Luxury", "Sleeper"},
                arr
        );
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] arr = {"A", "B", "C"};
        Main.sortBogieNames(arr);
        assertArrayEquals(new String[]{"A", "B", "C"}, arr);
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] arr = {"Sleeper", "AC Chair", "Sleeper"};
        Main.sortBogieNames(arr);
        assertArrayEquals(
                new String[]{"AC Chair", "Sleeper", "Sleeper"},
                arr
        );
    }

    @Test
    void testSort_SingleElementArray() {
        String[] arr = {"Luxury"};
        Main.sortBogieNames(arr);
        assertArrayEquals(new String[]{"Luxury"}, arr);
    }
}