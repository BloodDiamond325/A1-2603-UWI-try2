import java.awt.*;
import java.util.ArrayList;

/*
 * The hub that receives packages, packs them into containers,
 * dispatches containers, and produces financial reports.
 */
public class FreightTerminal {

    // TO DO M1: These fields are declared but not yet initialized.
    // Your constructor (M2) must initialize them.
    private String terminalName;
    private ArrayList<Package> pendingPackages;
    private ArrayList<Container> activeContainers;
    private ArrayList<Container> dispatchedContainers;
    private int totalPackagesReceived = 0;
    private int totalContainersPacked = 0;
    private int totalContainersReceived;


    //TO DO M2: Initialise terminalName and all three ArrayLists.
    public FreightTerminal(String terminalName) {
        // TO DO M2
        this.terminalName = terminalName;
        this.pendingPackages = new ArrayList<>();
        this.activeContainers = new ArrayList<>();
        this.dispatchedContainers = new ArrayList<>();
    }

   // public String getDestination() {return this.destination; }

    //TO DO M4: Add a non-null package to pendingPackages.
    public void receivePackage(Package p) {// TO DO M4
        if (p!=null){
            pendingPackages.add(p);
            totalPackagesReceived++;
        }
    }

    //TO DO M4: Return the size of pendingPackages.
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
    public int packContainers() {// TO DO M8
        ArrayList<String> destinations = new ArrayList<String>();
        for (Package p : pendingPackages) {
            if (!destinations.contains(p.getDestination())) {
                destinations.add(p.getDestination());
            }
        }
        for(String destination : destinations) {
            Container c = new Container(destination);
            for(Package p : pendingPackages) {
                if(p.getDestination().equals(destination)) {
                    c.addPackage(p);
                }
            }
            activeContainers.add(c);
        }
        pendingPackages.clear();
        totalContainersPacked += destinations.size();
        return destinations.size();
    }

    /*
     * TO DO M9: Move all activeContainers to dispatchedContainers.
     *   Clear activeContainers. Return the count dispatched.
     */
    public int dispatchAll() {// TO DO M9
        int count = activeContainers.size();
        dispatchedContainers.addAll(activeContainers);
        activeContainers.clear();
        return count;
    }

    //TO DO M9: Return the sum of getTotalRevenue() across all
    //dispatched containers.
    public double getTotalRevenue() {// TO DO M9
        double totalRevenue = 0;
        for (Container c : dispatchedContainers) {
            totalRevenue += c.getTotalRevenue();
        }
        return totalRevenue;
    }

     // TO DO M9: Return the sum of getPackageCount() across all
     // dispatched containers.
    public int getTotalPackagesShipped(){ // TO DO M9
    int total = 0;
    for (Container c : dispatchedContainers) {
        total += c.getPackageCount();
    }
        return total;
    }

    /*
     * TO DO M9: Search pending, active containers, and dispatched
     *   containers for a package with the given tracking ID.
     *   Return the Package or null if not found.
     */
    public Package findPackage(String trackingId) {// TO DO M9
        //pending packages
        for (Package p : pendingPackages) {
            if (p.getTrackingId().equals(trackingId)) {
                return p;
            }
        }
        for (Container c : activeContainers) {
            for (Package p : c.getPackages()){
                if (p.getTrackingId().equals(trackingId)) {
                    return p;
                }
            }
        }
        for (Container c : dispatchedContainers) {
            for (Package p :  c.getPackages()){
                if (p.getTrackingId().equals(trackingId)) {
                    return p;
                }
            }
        }
        return null;
    }

         // Returns the list of active containers (for printing manifests in Driver).
        public ArrayList<Container> getActiveContainers () {
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
     *   Revenue by destination:
     *     Trinidad:    $199.50 (3 packages)
     *     Barbados:    $1403.00 (3 packages)
     *     ...
     */
    public void printDailyReport() {// TO DO M10
        System.out.println("=== Daily Report: " + terminalName + " ===");

        System.out.println("Packages Received: " + totalPackagesReceived);
        System.out.println("Containers Packed: " + totalContainersPacked);
        System.out.println("Packages Dispatched: " + getTotalPackagesShipped());
        System.out.println("Packages Shipped: " + getTotalPackagesShipped());
        System.out.printf("Total Revenue: $%.2f%n", getTotalRevenue());
        System.out.println("Revenue by destination:");

        for (Container c : dispatchedContainers) {
            System.out.printf(" %-12s $%.2f (%d packages)%n",
                    c.getDestination() + ":", c.getTotalRevenue(), c.getPackageCount());
        }
    }

    public int getTotalContainersReceived() {
        return totalContainersReceived;
    }

    public void setTotalContainersReceived(int totalContainersReceived) {
        this.totalContainersReceived = totalContainersReceived;
    }
}
