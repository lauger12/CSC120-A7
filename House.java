import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    this.residents = new ArrayList<>();
  }

  /**
   * Getter for hasDiningRoom
   * 
   * @return T/F value for whether the house has a dining room
   */
  public boolean getHasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Getter for nResidents (called num residents for camelcase's sake)
   * 
   * @return nResidents, int for number of residents in the house
   */
  public int getNumResidents() {
    return this.residents.size();
  }

  /**
   * Adds a given resident to the residents ArrayList
   * 
   * @param name name of resident
   */
  public void moveIn(String name) {
    try {
      this.residents.add(name);
    } catch (InputMismatchException e) {
      System.out.println("Please enter a string"); // exception catching for if we use a scanner later on to add
    }
  }


    /**
   * Appends a String ArrayList of new residents to the residents ArrayList
   * overloaded method (allowing for multiple move ins at once instead of only individuals)
   * 
   * @param name ArrayList of new residents
   */
  public void moveIn(ArrayList<String> name) {
    try {
      this.residents.addAll(name);
    } catch (InputMismatchException e) {
      System.out.println("Please enter a list of students"); // exception catching for if we use a scanner later on to add
    }
  }


  /**
   * Adds a given resident to the residents ArrayList
   * 
   * @param name name of resident
   */
  public String moveOut(String name) { // return the name of the person who moved out
    try {
      if (this.residents.contains(name)) {
        this.residents.remove(name);
        // System.out.println("Resident " + name + " has moved out of " + this.name);
        return name;
      } else {
        throw new RuntimeException("Hey you're not in this house! You can't move out!");
      }
    } catch (InputMismatchException d) {
      System.out.println("Please enter a string"); // this is if we use a scanner later, and someone enters a non-string
                                                   // value
      return name;
    } catch (RuntimeException f) {
      System.out.println(f.getMessage());
      return name;
    }
  }

  /**
   * Returns whether a given person is a resident in a house
   * 
   * @param person person to check
   * @return T/F whether or not the person is a resident in a house
   */
  public boolean isResident(String person) {
    return (this.residents.contains(person));
  }

  /**
   * toString for House class
   * 
   * @return toString description of the house
   */
  public String toString() {
    String desc = super.toString();
    if (this.hasDiningRoom) {
      desc += ", it has a dining room.";
    }
    if (this.hasElevator) {
      desc += ", it has an elevator.";
    }
    return desc;
  }

  public static void main(String[] args) {
    House morris = new House("Morris House", "101 Green Street in NoHo", 4, true, true);
    System.out.println(morris);
    ArrayList<String> r = new ArrayList<>(Arrays.asList("Student 1", "Student 2", "etc"));
    morris.moveIn(r);
    System.out.println(morris.residents);
    morris.moveIn("A.Student");
    System.out.println(morris.residents);
  }
}