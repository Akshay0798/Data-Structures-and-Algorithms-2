import java.util.Stack;

//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
public class MiniParenthesisValid {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == ')') { //If the character is a closing parenthesis
                if (!stack.isEmpty() && stack.peek() == '(') { // If the stack is not empty, and the top element is an opening parenthesis
                    stack.pop();// Match found, remove the opening parenthesis from the stack
                } else {
                    stack.push(ch);  // No matching opening parenthesis found, add the closing parenthesis to the stack
                }
            } else {
                stack.push(ch); // If the character is an opening parenthesis, add it to the stack
            }
        }
        return stack.size(); // The remaining elements in the stack are unbalanced parentheses
    }

    public static void main(String[] args) {
        MiniParenthesisValid solution = new MiniParenthesisValid();
        String parentheses = "()(())";
        int minAdditions = solution.minAddToMakeValid(parentheses);
        System.out.println("Minimum additions to make the parentheses valid: " + minAdditions);
    }
}

