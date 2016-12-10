import java.io.*;
import java.util.*;

public class InventoryManager {
  
  public static void main(String[] args) throws IOException {
    Map<Object, String> inventory = new HashMap<>();
    Scanner scan = new Scanner(new File(args[0]));

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
    FileOutputStream fouts = new FileOutputStream("database");
    ObjectOutputStream obos = new ObjectOutputStream(fouts);
    obos.writeObject(inventory);
    
  }
  
  public static Map displayInventory(String fileName) throws IOException, FileNotFoundException, ClassNotFoundException {
    FileInputStream fins = new FileInputStream(fileName);
    ObjectInputStream obis = new ObjectInputStream(fins);
    Map<Item, String> inventory = (HashMap<Item, String>) obis.readObject(); // unchecked cast
    obis.close();
    return inventory;
  }
}