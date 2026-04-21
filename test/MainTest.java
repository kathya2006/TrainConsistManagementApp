import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    // Helper classes for testing
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type) {
            this.type = type;
        }

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        void assignCargo(String cargo) {
            if (cargo.equals("Petroleum") && !this.type.equals("Cylindrical")) {
                System.out.println("Error: Petroleum can only be in Cylindrical bogies.");
                this.cargo = null;
            } else {
                this.cargo = cargo;
            }
        }
    }

    @Test
    void testFilterBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(2, filtered.size());
        assertEquals("Sleeper", filtered.get(0).name);
    }

    @Test
    void testUC9_GroupBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("Sleeper", 70));

        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(2, grouped.get("Sleeper").size());
        assertEquals(1, grouped.get("AC Chair").size());
    }

    @Test
    void testUC10_TotalSeats() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));

        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(128, totalSeats);
    }

    @Test
    void testUC11_ValidateTrainAndCargo() {
        String trainId = "TRN-6524";
        String cargoCode = "PET-FH";

        assertTrue(trainId.matches("TRN-\\d{4}"));
        assertTrue(cargoCode.matches("PET-[A-Z]{2}"));
    }

    @Test
    void testUC12_SafetyCompliance() {
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Petroleum")); // Invalid

        boolean isSafe = goodsBogies.stream()
                .allMatch(b -> !b.cargo.equals("Petroleum") || b.type.equals("Cylindrical"));

        assertFalse(isSafe);
    }

    @Test
    void testUC15_Cargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("Cylindrical");
        bogie.assignCargo("Petroleum");
        assertEquals("Petroleum", bogie.cargo);
    }

    @Test
    void testUC15_Cargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");
        assertNull(bogie.cargo);
    }
}