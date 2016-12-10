import java.io.*;

public class Item implements Serializable {
  String name;
  String price;
  String image;
  
  public String toString() {
    return this.name + " $" + this.price; 
  }
}