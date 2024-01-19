/*
package QUEUE;

public class DynamicQueue extends Custom_CircularQueue {
    public DynamicQueue() {
        super();
    }
    
    public DynamicQueue(int size) {
        super(size);
    }
    
    @Override
    public boolean insert(int item) {
        // this takes care of it being full
        if (this.isFull()) {
            // double the array size
            int[] temp = new int[data.length * 2];
            // copy all previous items in new data
            // its zeroth item from the front till end
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[(front + i) % data.length];
            }
            front = 0;
            this.end = data.length-1;  // Use this.end to access the end variable
            data = temp;
        }
        // at this point, we know that array is not full
        // insert item
        return super.insert(item);
    }
    
    public static void main(String[] args) {
        // Example usage of DynamicQueue
        DynamicQueue dynamicQueue = new DynamicQueue(4);
        dynamicQueue.insert(2);
        dynamicQueue.insert(22);
        dynamicQueue.insert(32);
        dynamicQueue.insert(42);
        dynamicQueue.insert(52);
        dynamicQueue.insert(62);
        
        dynamicQueue.display();
    }
}
*/
