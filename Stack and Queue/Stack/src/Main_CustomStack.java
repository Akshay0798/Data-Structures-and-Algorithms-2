package STACK;

public class Main_CustomStack {
    public static void main(String[] args) throws Stack_CustomException {

//        CustomStack stack = new CustomStack(5);
//        stack.push(45);
//        stack.push(56);
//        stack.push(15);
//        stack.push(32);
//        stack.push(61);
//        stack.push(31);

//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//---------------------------------------------------------------------
//        DynamicStack stack = new DynamicStack(5);
//        stack.push(45);
//        stack.push(56);
//        stack.push(15);
//        stack.push(32);
//        stack.push(61);
//        stack.push(31);

//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//--------------------------------------------------------------------------
        CustomStack stack = new DynamicStack(5);
        stack.push(45);
        stack.push(56);
        stack.push(15);
        stack.push(32);
        stack.push(61);
        stack.push(31);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
