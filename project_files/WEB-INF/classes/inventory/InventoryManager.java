package inventory;

import java.io.*;
import java.util.*;

public class InventoryManager {
  // run in Tomcat
  final static String DATABASE = "/u/ecrichlo/c212-workspace/apache-tomcat-7.0.35/webapps/shopping-cart/WEB-INF/database";
  final static String INIT = "../inventoryInit.txt";
  // run in DrJava (windows)
//  final static String DATABASE = "..\\database";
//  final static String INIT = "..\\inventoryInit.txt";
  
  public static void main(String[] args) throws IOException {
    Map<Item, Integer> inventory = new HashMap<>(); // this was initialized as <Object, String> - why?
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
        
        inventory.put(item, quantity); // this was cast to Object - why?
    }
    updateDatabase(inventory);
  }
  
  public static Item getItem(Integer sku) throws IOException, ClassNotFoundException {
    @SuppressWarnings("unchecked") Map<Item, Integer> inventory = getInventory(); // returns HashMap
    Item temp = new Item();
    for (Item item : inventory.keySet()) {
      if (sku == item.getSku()) {
        temp = item;
        break;
      }
    }
    return temp;
  }
  
  public static void updateDatabase(Map<Item, Integer> inventory) throws IOException, FileNotFoundException {
    FileOutputStream fouts = new FileOutputStream(DATABASE);
    ObjectOutputStream obos = new ObjectOutputStream(fouts);
    obos.writeObject(inventory);
  }
  
  public static Map getInventory() throws IOException, FileNotFoundException, ClassNotFoundException {
    FileInputStream fins = new FileInputStream(DATABASE);
    ObjectInputStream obis = new ObjectInputStream(fins);
    @SuppressWarnings("unchecked") Map<Item, Integer> inventory = (HashMap<Item, Integer>) obis.readObject();
    obis.close();
    return inventory;
  }
  
  public static String updateInventory(Map<Item, Integer> cart) throws IOException, ClassNotFoundException {
    @SuppressWarnings("unchecked") Map<Item, Integer> inventory = getInventory(); // returns HashMap
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
              + ", Quantity: " + cart.get(update);
          }
          inventory.put(item, newStock);
        }
      }
    }
    updateDatabase(inventory);
    // There should be some kind of monetary transaction... right now FREE
    return message + "\n";
  }
  
}