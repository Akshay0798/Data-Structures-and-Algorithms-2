package QUEUE;

public class CustomQueue {
    private int[] data;
    private static final int DEFAULT_SIZE = 10;
    int end = 0;
    
    public CustomQueue() {
        this(DEFAULT_SIZE);
    }
    
    public CustomQueue(int size) {
        this.data = new int[size];
    }
    
    public boolean isFull() {
        return end == data.length; // ptr is at last index
    }
    
    public boolean isEmpty() {
        return end == 0;
    }
    
    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }
        data[end++] = item; // 1st assign item then increase
        return true;
    }
    
    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        int removed = data[0];
        // shift the elements to the left
        for (int i = 1; i < end; i++) {
            data[i - 1] = data[i];
        }
        end--;
        return removed;
    }
    
    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return data[0];
    }
    
    public void display() {
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("END");
    }
    
    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue(5);
        try {
            queue.insert(1);
            queue.insert(2);
            queue.insert(3);
            
            System.out.println("Front: " + queue.front());
            queue.display();
            
            queue.remove();
            System.out.println("After removing an element:");
            queue.display();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
