package inventory;

import java.util.*;
import java.io.*;

public class DisplayInventoryTest {
  public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
    
    @SuppressWarnings("unchecked") Map<Item, String> inventory = InventoryManager.displayInventory(); // returns HashMap
    
    for (Item item : inventory.keySet()) {
      System.out.println(item.name + " $" + item.price + "\nQuantity: " + inventory.get(item) + "\nImage: " + item.image);
    }
  }
}