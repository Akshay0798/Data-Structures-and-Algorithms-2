package QUEUE;

public class Custom_CircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    
    protected int end = 0;
    protected int front = 0;
    private int size = 0;
    
    public Custom_CircularQueue() {
        this(DEFAULT_SIZE);
    }
    
    public Custom_CircularQueue(int size) {
        this.data = new int[size];
    }
    
    public boolean isFull() {
        return size == data.length; // ptr is at last index
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }
    
    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        
        int removed = data[front++];
        front = front % data.length;
        size--;
        return removed;
    }
    
    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return data[front];
    }
    
    public void display() { //O(n) only for display
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        int i = front;
        do {
            System.out.print(data[i] + " <- ");
            i++;
            i %= data.length;
        } while (i != end);
        System.out.println("END");
    }
    
    public static void main(String[] args) {
        Custom_CircularQueue queue = new Custom_CircularQueue(5);
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
