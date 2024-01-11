import java.util.Stack;
//https://leetcode.com/problems/valid-parentheses/
public class ValidParenthesis {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for (char ch:s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch== '['){
                stack.push(ch);
            }else{
                if (ch == ')'){
                    if (stack.isEmpty() || stack.pop() != '(' ){
                        return false;
                    }
                }
                if (ch == '}'){
                    if (stack.isEmpty() || stack.pop() != '{'){
                        return false;
                    }
                }
                if (ch == ']'){
                    if (stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        // Create an instance of the ValidParenthesis class
        ValidParenthesis validator = new ValidParenthesis();


        String input1 = "()";
        boolean result1 = validator.isValid(input1);
        System.out.println(input1 + " is valid: " + result1);

        String input2 = "()[]{}";
        boolean result2 = validator.isValid(input2);
        System.out.println(input2 + " is valid: " + result2);

        String input3 = "(]";
        boolean result3 = validator.isValid(input3);
        System.out.println(input3 + " is valid: " + result3);
    }
}
/*
Let's consider the case where stack.isEmpty() is true (the stack is empty).
 In this situation, we can already determine that the overall result of the
 expression stack.isEmpty() || stack.pop() != '{' will be true.
 The value of stack.pop() != '{' is irrelevant because true || anything will
 always evaluate to true. Therefore, the condition stack.pop() != '{' is not
 evaluated when the stack is empty because it is not necessary to determine the
 final result.
*/
