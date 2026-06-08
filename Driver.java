
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
m8
m9
m10

 */
public class Driver {

    public static void main(String[] args) {

        // Step 1: Create the terminal
        // TO DO M10: Create a FreightTerminal named "Port of Spain Hub"

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

        // Step 3: Print pending count
        // TO DO M10: Print "=== Pending: 12 packages ==="

        // Step 4: Print first package details for verification
        // TO DO M10: Print p1.toString() and its shipping cost

        // Step 5: Pack containers
        // TO DO M10: Call packContainers() and print "Packed into N containers"

        // Step 6: Print manifests for all active containers
        // TO DO M10: Loop through getActiveContainers() and print each manifest

        // Step 7: Dispatch all containers
        // TO DO M10: Call dispatchAll() and print "Dispatched N containers"

        // Step 8: Print daily report
        // TO DO M10: Call printDailyReport()

        // Step 9: Find a package
        // TO DO M10: Find "PKG-0005" and print "Found: " + result

        // Step 10: Try to find a non-existent package
        // TO DO M10: Find "PKG-9999" and print "PKG-9999: Not found" if null
    }
}
