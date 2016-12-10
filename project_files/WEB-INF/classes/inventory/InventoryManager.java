package inventory;

import java.io.*;
import java.util.*;

public class InventoryManager {
  final static String FILEOUT = "D:\\ZAB (D)\\IU Courses\\C212\\FinalProject\\GitRepo\\c212-shopping-cart\\project_files\\database";
  final static String FILEIN = "D:\\ZAB (D)\\IU Courses\\C212\\FinalProject\\GitRepo\\c212-shopping-cart\\project_files\\inventory.txt";
  
  public static void main(String[] args) throws IOException {
    Map<Object, String> inventory = new HashMap<>();
    Scanner scan = new Scanner(new File(FILEIN));

    while (scan.hasNextLine())
    {
        Scanner line = new Scanner(scan.nextLine());
        line.useDelimiter("\t");
        
        Item item = new Item();
        item.name = line.next().trim();
        item.price = line.next().trim();
        String quantity = line.next().trim();
        item.image = line.next().trim();
        
        inventory.put((Object) item, quantity);
    }  
    FileOutputStream fouts = new FileOutputStream(FILEOUT);
    ObjectOutputStream obos = new ObjectOutputStream(fouts);
    obos.writeObject(inventory);
    
  }
  
  public static Map displayInventory() throws IOException, FileNotFoundException, ClassNotFoundException {
    FileInputStream fins = new FileInputStream(FILEOUT);
    ObjectInputStream obis = new ObjectInputStream(fins);
    @SuppressWarnings("unchecked") Map<Item, String> inventory = (HashMap<Item, String>) obis.readObject();
    obis.close();
    return inventory;
  }
}