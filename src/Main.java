import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static int size = 0;

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in); 
        Order oder = new Order(); 

        while (true) {
            try {
                System.out.println("Order here screen\r\n" +
                        "---------------------------\r\n" +
                        "1- Create a new order\r\n" +
                        "2- Switch to (Receive here screen)");
                
                int screen = myObj.nextInt();
                if (screen == 1) {
                    createOrder(myObj, oder);
                } else if (screen == 2) {
                    screenNumTwo(myObj, oder);
                } else {
                    System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input." + "\n" + e);
                myObj.next(); 
            }
        }
    }

    private static void createOrder(Scanner myObj, Order oder) {
        ArrayList<Integer> orders = new ArrayList<>();
        int order = 0;

        while (order != 4) {
            System.out.println("Take the order:\r\n" +
                    "\r\n" +
                    "1- Burger\r\n" +
                    "2- Fries\r\n" +
                    "3- Pepsi\r\n" +
                    "4- Finish the order and check out");

            order = myObj.nextInt();
            if (order >= 1 && order < 4) {
                orders.add(order);
            } else if (order == 4) {
                if (Main.size < 4) {
                    oder.addOrder(orders);
                    Main.size++;
                } else {
                    System.out.println("Error: 3 orders are pending, deliver one order to be able to add a new one.");
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void screenNumTwo(Scanner myObj, Order oder) {
        while(true){
        System.out.println("Receive here screen\r\n" +
                "---------------------------\r\n" +
                "1- Serve order.\r\n" +
                "2- Print all pending orders.\r\n" +
                "3- Switch to (Receive here screen).");

        int screen2 = myObj.nextInt();
        if (screen2 == 1) {
            oder.pop();
        } else if (screen2 == 2) {
            oder.printTotal();
        }else if(screen2 == 3){
            createOrder(myObj, oder);
        }else{
            System.out.println("Error message:\r\n" + //
            "3 orders are pending, deliver one order to be able to add a new one.\r\n" + //
            "\r\n" + //
            "1- Back to Order here screen.  ");
        }
        
        
       }
    }
}
