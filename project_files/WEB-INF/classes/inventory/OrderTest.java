package inventory;

import java.util.*;
import java.io.*;

public class OrderTest {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    getAllOrdersTest();
    addOrderTest();
    addOrderTest();
    getAllOrdersTest();
  }
  public static void getAllOrdersTest() throws IOException, ClassNotFoundException {
    System.out.println(OrderManager.getAllOrders());
  }
  public static void addOrderTest() throws IOException, ClassNotFoundException {
    Item a = new Item(100, "Low Gap Trail", 10.00, "http://www.hoosierhikerscouncil.org/assets/DNR_Low_Gap_Trails_Map.jpg");
    Item b = new Item(200, "Pate Hollow Trail", 5.00, "http://www.indianaoutfitters.com/Destinations/Hoosier_National/pate_hollow_trail_map_topo2.gif");
    Map<Item, Integer> cart = new HashMap<Item, Integer>();
    cart.put(a, 4);
    cart.put(b, 1);
    Map<Integer, Map<Item, Integer>> order = new HashMap<>();
    order.put(OrderManager.getNewOrderNumber(), cart);
    OrderManager.addOrder(order);
  }
}