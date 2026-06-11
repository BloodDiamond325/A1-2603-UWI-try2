//hi, testing
import java.util.ArrayList;
/*
 * Represents a shipping container bound for a single destination.
 * Holds packages and enforces a maximum weight capacity.
 */
public class Container {

    // TO DO M1: Initialise this static counter to 1.---------------------------------------------done
    private static int nextContainerId = 1;
    // TO DO M1: These fields are declared but not yet assigned.
    // Your constructors (M2, M3) must assign them.
    private String containerId;
    private String destination;
    private double maxWeightKg;
    private ArrayList<Package> packages;
    private double WeightKG;

    /*
     * Full constructor with destination and max weight.
     * TO DO M2: Implement this constructor.
     *   - Validate: destination non-null, maxWeightKg > 0.........................................done
     *   - Auto-assign containerId using String.format("CNT-%03d", nextContainerId)................done
     *   - Increment nextContainerId...............................................................done
     *   - Initialise the packages ArrayList.......................................................done
     */
    public Container(String destination, double maxWeightKg) {
        // TO DO M2
        if (destination == null) {
            throw new IllegalArgumentException("destination cannot be null");}
        if (maxWeightKg <= 0) {
            throw new IllegalArgumentException("maxWeightKg cannot be negative");}
        containerId = String.format("CNT-%03d", nextContainerId++);
        packages = new ArrayList<Package>();
        this.maxWeightKg = maxWeightKg;
        this.destination = destination;
    }

    /*
     * Convenience constructor: default capacity of 500 kg.
     * TO DO M3: Chain to the 2-param constructor using this(...)
     */
    public Container(String destination) {
        // TO DO M3: Write the this(...) call here
        this(destination, 500.0);
    }

    // --- Getters ---
    // TO DO M4: Write getters for containerId, destination, maxWeightKg
    public String getContainerId() {return containerId;}
    public String getDestination() {return destination;}
    public double getMaxWeightKg() {return maxWeightKg;}
    public double getWeightKG() {return WeightKG;}

    /*
     * TO DO M8: Add a package to this container.
     *   Return false if: p is null, p's destination does not match, or
     *   adding p would exceed maxWeightKg.
     *   Return true on success.
     */
    public boolean addPackage(Package p) {// TO DO M8
        if (p == null|| getCurrentWeightKg() + p.getWeightKg() > getMaxWeightKg() || !p.getDestination().equals(destination)) {
            return false;}
        return packages.add(p);
    }

    //TO DO M8: Return the sum of all packages' weightKg.
    public double getCurrentWeightKg() {// TO DO M8
        double total = 0.0;
        for (Package p : packages) {
           total += p.getWeightKg();}
        return total;
    }

    // TO DO M8: Return maxWeightKg - getCurrentWeightKg()
    public double getRemainingCapacityKg() {// TO DO M8
        return maxWeightKg - getCurrentWeightKg();
    }

    //TO DO M8: Return the number of packages
    //in this container using packages.size().
    public int getPackageCount() {// TO DO M8
        return packages.size();
    }

    // TO DO M8: Return the sum of all packages' getShippingCost().
    public double getTotalRevenue() {// TO DO M8
        double shipCost = 0.0;
        for (Package p : packages) {
            shipCost += p.getShippingCost();}
        return shipCost;
    }

    /*
     * TO DO M9: Build and return the multi-line manifest string.
     * Format:
     *   === CNT-001 -> Trinidad (3 packages, 17.00 / 500.00 kg) ===
     *     PKG-0001  Alice -> Bob  Trinidad  5.00 kg  $40.00
     *     PKG-0005  Ivy -> Jack  Trinidad  8.00 kg  $95.00  [FRAGILE]
     *     ...
     *     Container revenue: $199.50
     * Each package line is indented with 2 spaces.
     * Use StringBuilder and String.format.
     */
    public String getManifest() {
         // TO DO M9
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("=== %s -> %s (%d packages, %.2f / %.2f kg) ===%n",
                containerId, destination, packages.size(),
                getCurrentWeightKg(), maxWeightKg));
        double revenue = 0.0;
        for (Package p : packages) {
            sb.append("  ");
            sb.append(p.toString());
            sb.append(System.lineSeparator());
            revenue += p.getShippingCost();
        }
        sb.append(String.format("  Container revenue: $%.2f", revenue));
        return sb.toString();
    }

    //Returns the list of packages (needed by FreightTerminal.findPackage).
    public ArrayList<Package> getPackages() {
        return packages;
    }


    //TO DO M9: Return a one-line summary:
    //"CNT-001 -> Trinidad [3 packages, 17.00 / 500.00 kg]"
    @Override
    public String toString() {// TO DO M9
        return String.format(
                "%s -> %s [%d packages, %.2f / %.2f kg]", containerId, destination, packages.size(),
                getCurrentWeightKg(), maxWeightKg
        );
    }
}
