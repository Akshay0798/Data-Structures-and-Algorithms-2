package QUEUE;

public class DynamicQueue extends Custom_CircularQueue{
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
            //its zeroth item from the front till end
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[(front + i) % data.length];
            }
            front = 0;
            end = data.length;
            data = temp;
        }
        // at this point, we know that array is not a full
        // insert item
        return super.insert(item);
    }
}
