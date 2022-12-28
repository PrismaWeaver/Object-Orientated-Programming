// This class serves to keep track of which order is up next (head)
// and additions made to the list are added to tail.next, and then
// that addition becomes the new tail. dequeuing sets the head to head.next
public class queue {
    public pizza head, tail;
    public queue(){
        head = null;
        tail = null;
    }
    //creates a new pizza object with given address and ingrediants
    //assigns it to the head if list is empty, otherwise to tail
    public void enqueue(String ingrediants, String address){
        pizza thispizza = new pizza(ingrediants, address);
        if (head == null) {
            head = thispizza;
        }
        else tail.next = thispizza;
        tail = thispizza;
        return;
    }
    //returns current head, sets head to head.next
    public pizza dequeue(){
        pizza delivery = null;
        if (head != null) {
            delivery = head;
            head = head.next;
        }
        return delivery;

    }
    //prints out instructions relating to the dequeued pizza
    public void deliver(){
        pizza thispizza = dequeue();
        if (thispizza == null) {
            System.out.print("\nNo deliveries pending"); 
            return;
        }
        System.out.print("\nDeliver a pizza with ");
        System.out.print(thispizza.ingrediants);
        System.out.print(" to ");
        System.out.print(thispizza.address);
        return;
    }

}
