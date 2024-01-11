package STACK;

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int pointer=-1; //this will act as an index

    public CustomStack(){
        this(DEFAULT_SIZE); //CALLING ANOTHER CONSTRUCTOR WITH CONSTRUCTOR
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }
    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack is full");
            return false;
        }
        pointer++;
        data[pointer] = item;
        return true;
    }
    public int pop() throws Stack_CustomException{
        if(isEmpty()){
            throw new Stack_CustomException("Can not pop from an empty stack !");
        }
//        int removed = data[pointer];
//        pointer--;
//        return removed;
        return data[pointer--];
    }
    public int peek() throws Stack_CustomException {
        if(isEmpty()){
            throw new Stack_CustomException("Can not peek from an empty stack !");
        }
        return data[pointer];
    }

    public boolean isFull() {
        return pointer == data.length -1; //pointer is at last index
    }
    public boolean isEmpty(){
        return pointer == -1;
    }
}
