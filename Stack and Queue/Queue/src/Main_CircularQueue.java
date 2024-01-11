package QUEUE;

public class Main_CircularQueue {
    public static void main(String[] args) throws Exception {
//        Custom_CircularQueue queue = new Custom_CircularQueue(5);
//        queue.insert(2);
//        queue.insert(22);
//        queue.insert(32);
//        queue.insert(42);
//        queue.insert(52);
//        queue.insert(62);
//
//        queue.display();
//        queue.remove();
//        queue.display();
//        queue.insert(90);
//        queue.display();

        DynamicQueue queue = new DynamicQueue(4);
        queue.insert(2);
        queue.insert(22);
        queue.insert(32);
        queue.insert(42);
        queue.insert(52);
        queue.insert(62);

        queue.display();

    }

}
