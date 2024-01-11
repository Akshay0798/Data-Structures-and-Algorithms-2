public class Main {
    public static void main(String[] args) {
        Circuler list = new Circuler();
        list.insertLast(20);
        list.insertLast(30);
        list.insertLast(40);
        list.Display();


        list.insertFirst(99);
        list.Display();

        list.insertLast(88);
        list.Display();

        list.delete(10);
        list.Display();

        list.delete(30);
        list.Display();
    }
}
