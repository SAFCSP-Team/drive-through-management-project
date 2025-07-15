import java.util.*;
public class Main {
    static Item[] menu = {
        new Item(1, "Burger", 25),
        new Item(2, "Fries", 12.5),
        new Item(3, "Pepsi", 4.6)
    };
    static Queue<Order> orderQueue = new LinkedList<>();
    static final int MAX_ORDERS = 3;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean orderScreen = true;

        while (true) {
            if (orderScreen) {
                System.out.println("order here screen");
                System.out.println("------------------");
                System.out.println("1- create a new order");
                System.out.println("2- switch to (receive here screen)");
                System.out.print(">>> ");
                int choice = scanner.nextInt();

                if (choice == 1) {
                    if (orderQueue.size() >= MAX_ORDERS) {
                        System.out.println("3 orders are pending...., deliver one order to be able to add a new one! .\n");
                        continue;
                    }
                    Order order = new Order();
                    while (true) {
                        System.out.println("\nTake the order:");
                        System.out.println("1- Burger");
                        System.out.println("2- Fries");
                        System.out.println("3- Pepsi");
                        System.out.println("4- Finish the order and check out");
                        System.out.print("> ");
                        int itemChoice = scanner.nextInt();
                        if (itemChoice >= 1 && itemChoice <= 3) {
                            order.addItem(menu[itemChoice - 1]);
                        } else if (itemChoice == 4) {
                            System.out.println("\nOrder details:");
                            order.printOrder();
                            System.out.println("\n1- Create/add the order and go back to the (order here :)) screen");
                            System.out.print("> ");
                            int confirm = scanner.nextInt();
                            if (confirm == 1) {
                                orderQueue.add(order);
                                break;
                            }
                        } else {
                            System.out.println("Invalid option.");
                        }
                    }
                } else if (choice == 2) {
                    orderScreen = false;
                } else {
                    System.out.println("Invalid input.\n");
                }

            } else {
                System.out.println("receive here screen");
                System.out.println("---------------------");
                System.out.println("1- Serve order.");
                System.out.println("2- Print all pending orders.");
                System.out.println("3- Switch to (Order here screen).");
                System.out.print("> ");
                int choice = scanner.nextInt();

                if (choice == 1) {
                    if (orderQueue.isEmpty()) {
                        System.out.println("There are no pending orders\n");
                    } else {
                        Order served = orderQueue.poll();
                        System.out.println("Order ID " + served.ID + " served.\n");
                    }
                } else if (choice == 2) {
                    if (orderQueue.isEmpty()) {
                        System.out.println("There are no pending orders\n");
                    } else {
                        System.out.println("All the pending orders:\n");
                        for (Order o : orderQueue) {
                            o.printOrder();
                            System.out.println();
                        }
                    }
                } else if (choice == 3) {
                    orderScreen = true;
                } else {
                    System.out.println("Invalid input.\n");
                }
            }
        }
    }
}
