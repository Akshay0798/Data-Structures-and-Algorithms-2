package STACK;

public class DynamicStack extends CustomStack{
    public DynamicStack() {
        super(); //it will call CustomStack
    }
    public DynamicStack(int size){
        super(size); //it will call CustomStack(int size)
    }
    //if u want to use push of DynamicStack class not parent class

    @Override
    public boolean push(int item) {
        //this take care of being full
        if(this.isFull()){
            //double the array size
            int[] temp = new int[data.length * 2];

            //copy all previous item in new data
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
        //at this point we know that array os not full
        //insert item
        return super.push(item);
    }
}
