package inventory;

import java.util.*;
import java.io.*;

public class InventoryTest {
  // comment/uncomment methods to test
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    displayInventoryTest();
    updateInventoryTest();
    getItemTest();
  }
  public static void displayInventoryTest() throws IOException, ClassNotFoundException {
    @SuppressWarnings("unchecked") Map<Item, Integer> inventory = InventoryManager.getInventory(); // returns HashMap
    for (Item item : inventory.keySet()) {
      System.out.println(item.toString() + "\nStock: " + inventory.get(item) + "\nSKU: " + item.getSku() + "\nImage: " + item.getImage() + "\n");
    }
  }
  public static void updateInventoryTest() throws IOException, ClassNotFoundException {
    Item a = new Item(100, "Low Gap Trail", 10.00, "http://www.hoosierhikerscouncil.org/assets/DNR_Low_Gap_Trails_Map.jpg");
    Item b = new Item(200, "Pate Hollow Trail", 5.00, "http://www.indianaoutfitters.com/Destinations/Hoosier_National/pate_hollow_trail_map_topo2.gif");
    Map<Item, Integer> cart = new HashMap<Item, Integer>();
    cart.put(a, 4);
    cart.put(b, 1);
    @SuppressWarnings("unchecked") ArrayList<String> response = InventoryManager.updateInventory(cart); // returns ArrayList
    for (String line : response) {
      System.out.println(line);
    }
  }
  public static void getItemTest() throws IOException, ClassNotFoundException {
    System.out.println(InventoryManager.getItem(500));
  }
}