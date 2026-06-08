import java.util.ArrayList;

/*
 * The hub that receives packages, packs them into containers,
 * dispatches containers, and produces financial reports.
 */
public class FreightTerminal {

    // TO DO M1: These fields are declared but not yet initialised.
    // Your constructor (M2) must initialise them.
    private String terminalName;
    private ArrayList<Package> pendingPackages;
    private ArrayList<Container> activeContainers;
    private ArrayList<Container> dispatchedContainers;

    /*
     * TO DO M2: Initialise terminalName and all three ArrayLists.
     */
    public FreightTerminal(String terminalName) {
        // TO DO M2

        this.terminalName = terminalName;
        this.pendingPackages = new ArrayList<>();
        this.activeContainers = new ArrayList<>();
        this.dispatchedContainers = new ArrayList<>();
    }









    /*
     * TO DO M4: Add a non-null package to pendingPackages.
     */
    public void receivePackage(Package p) {
        // TO DO M4
        pendingPackages.add(p);
    }

    /*
     * TO DO M4: Return the size of pendingPackages.
     */
    public int getPendingCount() {
        return pendingPackages.size(); // TO DO M4
    }












    /*
     * TO DO M8: This is the HARD method. Group pending packages by destination.
     *   1. Collect unique destinations in the order they first appear.
     *   2. For each destination, create a new Container (default capacity).
     *   3. Add all pending packages for that destination to the container.
     *   4. Move the container to activeContainers.
     *   5. Clear pendingPackages.
     *   6. Return the number of containers created.
     */
    public int packContainers() {
        return 0; // TO DO M8
    }






    
    /*
     * TO DO M9: Move all activeContainers to dispatchedContainers.
     *   Clear activeContainers. Return the count dispatched.
     */
    public int dispatchAll() {
        return 0; // TO DO M9
    }

    /*
     * TO DO M9: Return the sum of getTotalRevenue() across all
     *   dispatched containers.
     */
    public double getTotalRevenue() {
        return 0.0; // TO DO M9
    }

    /*
     * TO DO M9: Return the sum of getPackageCount() across all
     *   dispatched containers.
     */
    public int getTotalPackagesShipped() {
        return 0; // TO DO M9
    }

    /*
     * TO DO M9: Search pending, active containers, and dispatched
     *   containers for a package with the given tracking ID.
     *   Return the Package or null if not found.
     */
    public Package findPackage(String trackingId) {
        return null; // TO DO M9
    }

    /*
     * Returns the list of active containers (for printing manifests in Driver).
     */
    public ArrayList<Container> getActiveContainers() {
        return activeContainers;
    }

    /*
     * TO DO M10: Print the formatted daily report.
     * Format:
     *   === Daily Report: Port of Spain Hub ===
     *   Packages received:  12
     *   Containers packed:  5
     *   Packages shipped:   12
     *   Total revenue:      $3248.50
     *
     *   Revenue by destination:
     *     Trinidad:    $199.50 (3 packages)
     *     Barbados:    $1403.00 (3 packages)
     *     ...
     */
    public void printDailyReport() {
        // TO DO M10
    }
}
