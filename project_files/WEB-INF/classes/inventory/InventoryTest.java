package inventory;

import java.util.*;
import java.io.*;

public class InventoryTest {
  // Debugging - uncomment methods to test
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    displayInventoryTest();
    //updateInventoryTest();
  }
  public static void displayInventoryTest() throws IOException, ClassNotFoundException {
    @SuppressWarnings("unchecked") Map<Item, Integer> inventory = InventoryManager.getInventory(); // returns HashMap
    for (Item item : inventory.keySet()) {
      System.out.println(item.getName() + " $" + item.getPrice() + "\nQuantity: " + inventory.get(item) + "\nImage: " + item.getImage());
    }
  }
  public static void updateInventoryTest() {
    // duh
    //Item a = new Item("Low Gap Trail", "10.00", "http://www.hoosierhikerscouncil.org/assets/DNR_Low_Gap_Trails_Map.jpg");
    //Item b = new Item("Pate Hollow Trail", "5.00", "http://www.indianaoutfitters.com/Destinations/Hoosier_National/pate_hollow_trail_map_topo2.gif");
    
  }
}