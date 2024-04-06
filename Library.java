import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Arrays;

public class Library extends Building {

  private Hashtable<String, Boolean> collection;

  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();

  }

    /* Default constructor */
    public Library() {
      this("<Mako's Bookstore>", "<Shark Street>", 1);
  }

  /**
   * For the library specifically, movement between non-adjacent floors is allowed for libraries, since we can't check their elevator status
   * inherited from Building
   */

  public void goToFloor(int floorNum) {
   super.goToFloor(floorNum);
  }

  /**
   * adds a title to the collection hashtable
   * 
   * @param title the book-to-be-added's title
   */
  public void addTitle(String title) {
    try {
      this.collection.put(title, true);
    } catch (InputMismatchException e) {
      System.out.println("Please enter a valid title");
    }
  }

  /**
   * removes a title from the collection hashtable
   * 
   * @param title the book-to-be-removed's title
   * @return the title of the removed book
   */
  public String removeTitle(String title) {
    this.collection.remove(title);
    return title;
  }

  /**
   * checks out a book by setting the key's value to false
   * 
   * @param title the book-to-be-checked out's title
   * 
   */
  public void checkOut(String title) {
    if (isAvailable(title)) {
      this.collection.replace(title, false);
    } else {
      throw new RuntimeException("You can't check out this book, sorry!");
    }
  }

  /**
   * checks out books by setting their key's value to false
   * 
   * @param title ArrayList<String> for the books to be checked out
   * 
   */
  public void checkOut(ArrayList<String> title) {
    // if (this.collection.contains(title)) {
    for (int i = 0; i < title.size(); i++)
      this.collection.replace(title.get(i), false);
    // } else {
    // throw new RuntimeException("You can't check out these books, sorry!");
    // }
  }
  // (above) need to find a way to cycle through and check availibilty, removing
  // if statement for now

  /**
   * returns a book by setting the key's value to true
   * 
   * @param title the book-to-be-returned's title
   * 
   */
  public void returnBook(String title) {
    this.collection.replace(title, true);
  }

  /**
   * returns true if the title appears as a key in the Libary's collection, false
   * otherwise
   * 
   * @param title
   * @return T/F is the title a key in the Library collection?
   */
  public boolean containsTitle(String title) {
    if (this.collection.containsKey(title)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * returns true if the title is currently available, false otherwise
   * 
   * @param title
   * @return T/F whether the title is availble to checkout
   */
  public boolean isAvailable(String title) {
    if (this.collection.get(title)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * prints out the entire collection in an easy-to-read way (including checkout
   * status)
   */
  public void printCollection() {
    // System.out.println(this.collection.toString());
    System.out
        .println("Titles in Collection: " + this.collection.keySet() + " Availible?: " + this.collection.entrySet());
  }

  /**
   * modified showOptions method from Building (parent), shows the options for the
   * current building
   */
  public void showOptions() {
    super.showOptions();
    System.out.println(" + addTitle()" + "\n + removeTitle()" + "\n + checkOut()" + "\n + returnBook()"
        + "\n + containsTitle()" + "\n + isAvailible()" + "\n + printCollection()");
  }

  public static void main(String[] args) {
    Library n = new Library("Nielson", "address", 4);
    n.addTitle("Jaws");
    n.addTitle("Jaws 2");
    n.addTitle("Jaws 3");
    ArrayList<String> b = new ArrayList<>(Arrays.asList("Jaws", "Jaws 2"));
    n.checkOut(b);
    System.out.println(n.containsTitle("Jaws"));
    System.out.println(n.isAvailable("Jaws"));
    n.printCollection();

  }

}