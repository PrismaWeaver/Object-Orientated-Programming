// This class, pizza, stores the ingrediants and the address 
// for an order and references the next order in the list
public class pizza {
    public String ingrediants, address;
    public pizza next;
    public pizza(String ingrediants, String address) {
        this.ingrediants = ingrediants;
        this.address = address;
        this.next = null;
    }
}
