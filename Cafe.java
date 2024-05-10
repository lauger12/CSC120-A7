public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Constructor for Cafe
     * @param name
     * @param address
     * @param nFloors
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams,
            int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    /* Default constructor */
    public Cafe() {
        this("<John and Jane's Cafe>", "<An Unsuspicious Street>", 1, 32, 10, 10, 10);
    }

    /**
     * goToFloor for the Cafe class, where we don't want customers going onto
     * staff-only floors
     * 
     */
    public void goToFloor(int floorNum) {
        throw new RuntimeException("Hey! These other floors are staff only, you can't go to them.");
    }

    /**
     * Overriden method for goUp(), will always throw an exception, to prevent someone from entering a staff only floor (everything but main floor)
     */
    public void goUp() {
        throw new RuntimeException("Hey! These other floors are staff only, you can't go to them.");
    }

      /**
     * Overriden method for goDown(), will always throw an exception, to prevent someone from entering a staff only floor (everything but main floor)
     */
    public void goDown() {
        throw new RuntimeException("Hey! These other floors are staff only, you can't go to them.");
    }

    /**
     * decreases inventory values of ounces, sugar, cream, (and cups), based on
     * coffee sold
     * 
     * @param size
     * @param nSugarPackets
     * @param nCreams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCups < 1 || this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets
                || this.nCreams < nCreams) {
            System.out.println("Restocking...");
            this.restock(size, nSugarPackets, nCreams, 1);
            System.out.println("Restocked");
        }
        System.out.println("Selling Coffee");
        this.nCups -= 1;
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        System.out.println("Sold!");
    }

    /**
     * overloaded sellCoffee method for a default coffee order with no details
     * Default order is a 12 oz black coffee (no cream or sugar)
     * Still 1 cup used
     */
    public void sellCoffee() {
        if (this.nCups < 1 || this.nCoffeeOunces < 12) {
            System.out.println("Restocking...");
            this.restock(12, 0, 0, 1);
            System.out.println("Restocked");
        }
        System.out.println("Selling Coffee");
        this.nCups -= 1;
        this.nCoffeeOunces -= 12;
        System.out.println("Sold!");
    }

    /**
     * restocks cafe materials by adding the needed values for the order, used to add just what needed but now uses a bulk-order of 100 each
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    private void restock(int size, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += 100;
        this.nSugarPackets += 100;
        this.nCreams += 100;
        this.nCups += 100;
    }

    // public void goUp() {
    // throw new RuntimeException("Sorry, upstairs is staff only!");

    // }

    /**
     * modified showOptions method from Building (parent), shows the options for the
     * current building
     * didn't include private methods since customers aren't going to be able to use
     * methods such as restock
     * 
     */
    public void showOptions() {
        super.showOptions();
        System.out.println(" + sellCoffee()");
    }

    public static void main(String[] args) {
        Cafe c = new Cafe("Cafe Cafe", "12 Awesome Ave", 1, 32, 10, 10, 10);
        // c.sellCoffee(12, 1, 1);
        c.sellCoffee();
        // c.showOptions();
        System.out.println("Ounces Left:" + c.nCoffeeOunces);
    }

}
