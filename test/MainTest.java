import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testSort_BasicSorting() {
        int[] arr = {72, 56, 24, 70, 68};
        Main.bubbleSort(arr);
        assertArrayEquals(new int[]{24, 56, 68, 70, 72}, arr);
    }

    @Test
    void testSort_AlreadySortedArray() {
        int[] arr = {10, 20, 30, 40};
        Main.bubbleSort(arr);
        assertArrayEquals(new int[]{10, 20, 30, 40}, arr);
    }

    @Test
    void testSort_DuplicateValues() {
        int[] arr = {5, 2, 5, 1};
        Main.bubbleSort(arr);
        assertArrayEquals(new int[]{1, 2, 5, 5}, arr);
    }

    @Test
    void testSort_SingleElementArray() {
        int[] arr = {10};
        Main.bubbleSort(arr);
        assertArrayEquals(new int[]{10}, arr);
    }

    @Test
    void testSort_AllEqualValues() {
        int[] arr = {7, 7, 7, 7};
        Main.bubbleSort(arr);
        assertArrayEquals(new int[]{7, 7, 7, 7}, arr);
    }
}