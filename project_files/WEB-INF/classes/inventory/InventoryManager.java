package inventory;

import java.io.*;
import java.util.*;

public class InventoryManager {
  // run in Tomcat
  final static String INIT = "../inventoryInit.txt";
//  final static String DATABASE = "../database"; // ABANDON DATABASE!
//  // run in DrJava (windows)
//  final static String DATABASE = "..\\database";
//  final static String INIT = "..\\inventoryInit.txt";
  
  static Map<Item, Integer> inventory = new HashMap<>();
  
  public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(new File(INIT));
    while (scan.hasNextLine())
    {
        Scanner line = new Scanner(scan.nextLine());
        line.useDelimiter("\t");
        
        Item item = new Item();
        item.sku = Integer.parseInt(line.next().trim());
        item.name = line.next().trim();
        item.price = Double.parseDouble(line.next().trim());
        Integer quantity = Integer.parseInt(line.next().trim());
        item.image = line.next().trim();
        
        inventory.put(item, quantity);
    }
    //updateDatabase(inventory);
    
    //debugging
    System.out.println(inventory);
  }
  
  public static Map getInventory() {
    return inventory;
  }
  
  public static Item getItem(Integer sku) {
    Item i = new Item();
    for (Item item : inventory.keySet()) {
      if (sku == item.getSku()) {
        i = item;
        break;
      }
    }
    return i;
  }
  
  public static String updateInventory(Map<Item, Integer> cart) throws IOException {
    String message = "";
    // Check cart against inventory
    for (Item update : cart.keySet()) {
      for (Item item : inventory.keySet()) {
        // If match found
        if (update.getSku() == item.getSku()) {
          // Calculate new stock
          int newStock = inventory.get(item) - cart.get(update);
          // Send error if update is larger than stock
          if (newStock < 0) { 
            newStock = inventory.get(item); 
            message += "\nI'm sorry, we do not have enough in stock of an item you selected. It has been removed from your purchase."
              + "\nItem removed: " + item.getName()
              + ", Current stock: " + inventory.get(item);
          }
          // Otherwise send confirmation
          else {
            message += "\nItem purchased: " + item.getName() 
              + ", Quantity: " + inventory.get(item);
          }
          inventory.put(item, newStock);
        }
      }
    }
    
    //debugging
    System.out.println(inventory);
    
    //updateDatabase(inventory);
    // There should be some kind of monetary transaction... right now FREE
    return message + "\n";
  }
  
//  public static void updateDatabase(Map<Item, Integer> inventory) throws IOException, FileNotFoundException {
//    FileOutputStream fouts = new FileOutputStream(DATABASE);
//    ObjectOutputStream obos = new ObjectOutputStream(fouts);
//    obos.writeObject(inventory);
//  }
  
//  public static Map getInventory() throws IOException, FileNotFoundException, ClassNotFoundException {
//    FileInputStream fins = new FileInputStream(DATABASE);
//    ObjectInputStream obis = new ObjectInputStream(fins);
//    @SuppressWarnings("unchecked") Map<Item, Integer> inventory = (HashMap<Item, Integer>) obis.readObject();
//    obis.close();
//    return inventory;
//  }
  
}