import java.util.ArrayList;

class Order {
    ArrayList<Item> order; 
    public double totalPrice = 0;  
    private Node rear = null;
    private Node front = null;
    private Item[] menu = {
        new Item(1, "Burger", 25),
        new Item(2, "Fries", 12.5),
        new Item(3, "Pepsi", 4.6)
    };

    private boolean isEmpty() {
        return this.front == null;
    }

    private ArrayList<Item> callItems(ArrayList<Integer> orders) {
        ArrayList<Item> items = new ArrayList<>();
        for (int itemID : orders) {
            if (itemID >= 1 && itemID <= menu.length) {
                items.add(this.menu[itemID - 1]);
            } 
        }
        return items;
    }

    public void addOrder(ArrayList<Integer> orders) {
        ArrayList<Item> items = callItems(orders);
        Node newNode = new Node(items);
        if (isEmpty()) {
            this.front = newNode;
            this.rear = newNode;
        } else {
            this.rear.next = newNode;
            this.rear = newNode;
        }
    }

    public void pop() {
        if (isEmpty()) {
            return;
        }
        Node curr = this.front;
        if (this.front == this.rear) {
            this.front = null;
            this.rear = null;
        } else {
            this.front = this.front.next;
        }
    }

    public void printTotal() {
        if (isEmpty()) {
            System.out.println("Error message:\r\n" + //
                                "There are no pending orders\r\n" + //
                                "\r\n" + //
                                "1- Back to (Receive here) screen.  ");
            return;
        }
        Node curr = this.front;
        int i =1;
        while (curr != null) {
            System.out.println("Order ID: " + i);
                i++;
                this.totalPrice = 0;
            for (Item item : curr.it) {
                System.out.println(item.name + ": "+item.price);
                this.totalPrice += item.price;
            }
            System.out.println("Total Price: " + this.totalPrice);
            curr = curr.next;
        }
        
    }
}
