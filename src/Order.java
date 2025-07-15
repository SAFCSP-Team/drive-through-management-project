import java.util.*;
public class Order {
    public static int nextId = 1;
    public int ID;
    public double totalPrise;
    public List<Item> items;

    public Order() {
        this.ID = nextId++;
        this.items = new ArrayList<>();
        this.totalPrise = 0.0;
    }
    public void addItem(Item item) {
        items.add(item);
        totalPrise += item.price;
    }
    public void printOrder() {
        System.out.println("Order ID: " + ID);
        for (Item item : items) {
            System.out.printf("%s %.2f\n", item.name, item.price);
        }
        System.out.printf("Total: %.2f\n", totalPrise);
    }
}
