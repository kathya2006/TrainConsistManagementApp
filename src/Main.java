public class Main {

    // Custom Runtime Exception
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Goods Bogie class
    static class GoodsBogie {
        String shape;
        String cargo;

        // Constructor
        GoodsBogie(String shape) {
            this.shape = shape;
        }

        // Assign cargo with validation
        void assignCargo(String cargo) {
            try {
                // Rule: Rectangular bogie cannot carry petroleum
                if (shape.equalsIgnoreCase("Rectangular") &&
                        cargo.equalsIgnoreCase("Petroleum")) {

                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }

                // Safe assignment
                this.cargo = cargo;
                System.out.println("Cargo assigned successfully -> " + cargo);

            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                // Always executes
                System.out.println("Cargo validation completed for " + shape + " bogie");
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        // Safe case
        GoodsBogie bogie1 = new GoodsBogie("Cylindrical");
        bogie1.assignCargo("Petroleum");

        System.out.println();

        // Unsafe case
        GoodsBogie bogie2 = new GoodsBogie("Rectangular");
        bogie2.assignCargo("Petroleum");

        System.out.println();

        System.out.println("UC15 runtime handling completed...");
    }
}