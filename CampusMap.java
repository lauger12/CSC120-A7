import java.util.ArrayList;
import java.util.Scanner;

public class CampusMap {
    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * 
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * 
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i++) {
            mapString += "\n  " + (i + 1) + ". " + this.buildings.get(i).getName() + " ("
                    + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    // public void walkAround(String userinput){
    // Scanner s = new Scanner(System.in);
    // userinput = s.nextLine();
    // while(userinput != "quit");
    // }
    // s.close();
    // }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("Seeyle Hall", "2 Seelye Dr, Northampton, MA 01060", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new House("Morris House", "101 Green Street Northampton, MA 01063", 4, false, true));
        myMap.addBuilding(new House("Lamont House", "15-19 Prospect Street Northampton, MA 01063", 4, true, true));
        myMap.addBuilding(new House("Chase House", "10 Elm Street Northampton, MA 01063", 4, true, true));
        myMap.addBuilding(new Cafe("Campus Center Cafe", "100 Elm St, Northampton, MA 01063", 1, 200, 200, 200, 200));
        myMap.addBuilding(new Cafe("Nielson Compass Cafe", "in Nielson Library", 1, 200, 200, 200, 200));
        myMap.addBuilding(new Library("Nielson Library", "Neilson Drive, Northampton, MA 01063", 5));
        myMap.addBuilding(new Library("Forbes Library", "20 West St, Northampton, MA 01060", 3));
        System.out.println(myMap);
    }
}
