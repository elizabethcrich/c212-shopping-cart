import java.util.*;
import java.io.*;

public class DisplayInventoryTest {
  public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
    Map<Item, String> inventory = new HashMap<>();
    inventory = InventoryManager.displayInventory("C:\\Users\\ecrichlo\\Desktop\\FinalProject\\database");
    
    for (Item item : inventory.keySet()) {
      System.out.println(item.name + " $" + item.price + "\nQuantity: " + inventory.get(item) + "\nImage: " + item.image);
    }
    
    //debugging
    //System.out.println(inventory);
  }
}