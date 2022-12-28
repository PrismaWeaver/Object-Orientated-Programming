public class main {
    public static void main(String[] args) {
    queue sanMarcosPizza = new queue();

    sanMarcosPizza.enqueue("pepperoni", "1234 Bobcat Trail");
    sanMarcosPizza.enqueue("sausage", "2345 University Drive");
    sanMarcosPizza.deliver();
    sanMarcosPizza.enqueue("extra cheese", "3456 Rickster Road");
    sanMarcosPizza.enqueue("everything", "4567 King Court");
    sanMarcosPizza.enqueue("coffee beans", "5678 Java Circle");
    sanMarcosPizza.deliver();
    sanMarcosPizza.deliver();
    sanMarcosPizza.deliver();
    sanMarcosPizza.deliver();
    sanMarcosPizza.deliver();
    }
}
