package inventory;

import java.io.*;
import java.util.*;

public class InventoryManager {
  final static String DATABASE = "..\\database";
  final static String INIT = "..\\inventoryInit.txt";
  
  public static void main(String[] args) throws IOException {
    Map<Item, Integer> inventory = new HashMap<>(); // this was initialized as <Object, String> - why?
    Scanner scan = new Scanner(new File(INIT));

    while (scan.hasNextLine())
    {
        Scanner line = new Scanner(scan.nextLine());
        line.useDelimiter("\t");
        
        Item item = new Item();
        item.name = line.next().trim();
        item.price = Double.parseDouble(line.next().trim());
        Integer quantity = Integer.parseInt(line.next().trim());
        item.image = line.next().trim();
        
        inventory.put(item, quantity); // this was cast to Object - why?
    }  
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
  
  // This should work to update after checkout and from admin screen
  public static void updateInventory(Map<Item, Integer> m) throws IOException, ClassNotFoundException {
    @SuppressWarnings("unchecked") Map<Item, Integer> inventory = getInventory(); // returns HashMap
    
    for (Item update : m.keySet()) {
      for (Item item : inventory.keySet()) {
        // maybe should be using a sku # ?
        if (update.equals(item)) {
          //debugging
          System.out.println("works");
        }
      }
    }
  }
  
}