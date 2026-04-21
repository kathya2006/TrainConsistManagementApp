import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testBinarySearch_BogieFound() {
        String[] arr = {"BG101", "BG205", "BG309"};
        assertTrue(Main.binarySearch(arr, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] arr = {"BG101", "BG205", "BG309"};
        assertFalse(Main.binarySearch(arr, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] arr = {"BG101", "BG205", "BG309"};
        assertTrue(Main.binarySearch(arr, "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] arr = {"BG101", "BG205", "BG309"};
        assertTrue(Main.binarySearch(arr, "BG309"));
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] arr = {"BG777"};
        assertTrue(Main.binarySearch(arr, "BG777"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] arr = {};
        assertFalse(Main.binarySearch(arr, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] arr = {"BG309", "BG101", "BG205"};
        assertTrue(Main.binarySearch(arr, "BG205"));
    }
}