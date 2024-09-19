import java.util.ArrayList;

public class Node {
        ArrayList<Item> it;
        Node next;
        Node prev;
    
        Node(ArrayList<Item> it){
            this.it = it;
            this.next = null;
        }
    }
    
