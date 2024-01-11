package QUEUE;

public class Main_CustomQueue {
    public static void main(String[] args) throws Exception {
        CustomQueue queue=new CustomQueue();
        queue.insert(3);
        queue.insert(13);
        queue.insert(23);
        queue.insert(33);
        queue.insert(43);

        queue.display();

        System.out.println(queue.remove());
        queue.display();
    }
}
