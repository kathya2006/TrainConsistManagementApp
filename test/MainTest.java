import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest{

    // Helper method
    boolean search(String[] bogieIds, String key) {
        if (bogieIds.length == 0) {
            throw new RuntimeException("No bogies available in train. Search cannot be performed.");
        }

        for (String id : bogieIds) {
            if (id.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] bogies = {};
        assertThrows(RuntimeException.class, () -> {
            search(bogies, "BG101");
        });
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] bogies = {"BG101", "BG205"};
        assertDoesNotThrow(() -> {
            search(bogies, "BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] bogies = {"BG101", "BG205"};
        assertTrue(search(bogies, "BG101"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] bogies = {"BG101", "BG205"};
        assertFalse(search(bogies, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] bogies = {"BG101"};
        assertTrue(search(bogies, "BG101"));
    }
}