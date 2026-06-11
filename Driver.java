
/*
 * Scripted demo of the Caribbean Cargo & Logistics System.
 * Creates 12 packages, packs and dispatches them, and prints reports.
 *
 * TO DO M10: Complete this class so that running "java Driver" produces
 * the exact expected output shown in the README.

m1............................done
m2............................done
m3............................done
m4............................done
m5............................done
m6............................done
m7............................done
m8............................done
m9............................done
m10...........................done

 */
public class Driver {

    public static void main(String[] args) {

        // Step 1: Create the terminal
        // TO DO M10: Create a FreightTerminal named "Port of Spain Hub"

        FreightTerminal terminal = new FreightTerminal("Port of Spain Hub");

        Package p1 = new Package("Alice", "Bob", 5.0, 40, 30, 20, "Trinidad");

        Package p2 = new Package("Carol", "Dan", 2.0, 60, 40, 40, "Barbados", true, 500);

        Package p3 = new Package("Eve", "Frank", 10.0, 30, 30, 30, "Jamaica");

        Package p4 = new Package("Grace", "Hank", 3.5, 50, 50, 50, "Barbados", false, 200);

        Package p5 = new Package("Ivy", "Jack", 8.0, 20, 20, 20, "Trinidad", true, 1000);

        Package p6 = new Package("Kim", "Leo", 1.5, 100, 60, 40, "Antigua");

        Package p7 = new Package("Mia", "Noah", 15.0, 40, 40, 30, "Jamaica", true, 750);

        Package p8 = new Package("Olivia", "Pat", 6.0, 35, 25, 15, "Grenada");

        Package p9 = new Package("Quinn", "Ray", 4.0, 45, 35, 25, "Trinidad", false, 100);

        Package p10 = new Package("Sara", "Tim", 20.0, 80, 60, 50, "Barbados", true, 2000);

        Package p11 = new Package("Uma", "Vic", 0.5, 15, 10, 10, "Grenada");

        Package p12 = new Package("Will", "Xia", 12.0, 50, 40, 30, "Antigua", true,300);

        // Step 2: Create and receive all 12 packages
        // TO DO M10: Create these 12 packages in order (PKG-0001 through PKG-0012):
        //
        //  #  | Sender  | Receiver | Weight | L   | W  | H  | Destination | Fragile | Value
        //  1  | Alice   | Bob      | 5.0    | 40  | 30 | 20 | Trinidad    | no      | 0
        //  2  | Carol   | Dan      | 2.0    | 60  | 40 | 40 | Barbados    | yes     | 500
        //  3  | Eve     | Frank    | 10.0   | 30  | 30 | 30 | Jamaica     | no      | 0
        //  4  | Grace   | Hank     | 3.5    | 50  | 50 | 50 | Barbados    | no      | 200
        //  5  | Ivy     | Jack     | 8.0    | 20  | 20 | 20 | Trinidad    | yes     | 1000
        //  6  | Kim     | Leo      | 1.5    | 100 | 60 | 40 | Antigua     | no      | 0
        //  7  | Mia     | Noah     | 15.0   | 40  | 40 | 30 | Jamaica     | yes     | 750
        //  8  | Olivia  | Pat      | 6.0    | 35  | 25 | 15 | Grenada     | no      | 0
        //  9  | Quinn   | Ray      | 4.0    | 45  | 35 | 25 | Trinidad    | no      | 100
        //  10 | Sara    | Tim      | 20.0   | 80  | 60 | 50 | Barbados    | yes     | 2000
        //  11 | Uma     | Vic      | 0.5    | 15  | 10 | 10 | Grenada     | no      | 0
        //  12 | Will    | Xia      | 12.0   | 50  | 40 | 30 | Antigua     | yes     | 300
        //
        // Use the 7-param constructor for non-fragile packages with value 0.
        // Use the 9-param constructor for packages that are fragile or have a declared value.
        // Receive each package into the terminal.

        terminal.receivePackage(p1);
        terminal.receivePackage(p2);
        terminal.receivePackage(p3);
        terminal.receivePackage(p4);
        terminal.receivePackage(p5);
        terminal.receivePackage(p6);
        terminal.receivePackage(p7);
        terminal.receivePackage(p8);
        terminal.receivePackage(p9);
        terminal.receivePackage(p10);
        terminal.receivePackage(p11);
        terminal.receivePackage(p12);



        // Step 3: Print pending count
        // TO DO M10: Print "=== Pending: 12 packages ==="
        System.out.println("=== Pending: " + terminal.getPendingCount() + " packages ===");

        // Step 4: Print first package details for verification
        // TO DO M10: Print p1.toString() and its shipping cost

        System.out.println(p1);
        System.out.printf("Shipping cost: $%.2f%n", p1.getShippingCost());

        // Step 5: Pack containers
        // TO DO M10: Call packContainers() and print "Packed into N containers"

        int packed = terminal.packContainers();
        System.out.println("Packed into " + packed + " containers");

        // Step 6: Print manifests for all active containers
        // TO DO M10: Loop through getActiveContainers() and print each manifest

        for (Container c : terminal.getActiveContainers()){
            System.out.println(c.getManifest());
        }

        // Step 7: Dispatch all containers
        // TO DO M10: Call dispatchAll() and print "Dispatched N containers"

        int dispatched = terminal.dispatchAll();
        System.out.println("Dispatched " + dispatched + " containers");

        // Step 8: Print daily report
        // TO DO M10: Call printDailyReport()

        terminal.printDailyReport();

        // Step 9: Find a package
        // TO DO M10: Find "PKG-0005" and print "Found: " + result

        Package found = terminal.findPackage("PKG-0005");
        System.out.println("Found: " + found);

        // Step 10: Try to find a non-existent package
        // TO DO M10: Find "PKG-9999" and print "PKG-9999: Not found" if null
        Package missing = terminal.findPackage("PKG-9999");

        if (missing == null) {
            System.out.println("PKG-9999: Not found");
        }
    }
}
