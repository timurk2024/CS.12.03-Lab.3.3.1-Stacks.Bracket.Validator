import java.util.Stack;

public class BracketValidator {

    public static boolean checkValidParentheses(String expression) {
        // Create a stack to hold opening brackets
        Stack<Character> stack = new Stack<>();

        // Iterate over the characters of the string
        for (char ch : expression.toCharArray()) {
            // If it's an opening bracket, push to stack
            if (isLeftBracket(ch)) {
                stack.push(ch);
            } else {
                // In case of a closing bracket
                // If the stack is empty or the top of the stack is not the matching opening bracket, return false
                if (stack.isEmpty() || stack.pop() != getReversedBracket(ch)) {
                    return false;
                }
            }
        }

        // If the stack is empty, all brackets were matched correctly
        return stack.isEmpty();
    }

    // Check if the character is an opening bracket
    private static boolean isLeftBracket(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }

    // Get the corresponding opening bracket for a closing one
    private static char getReversedBracket(char ch) {
        switch (ch) {
            case ')': return '(';
            case '}': return '{';
            case ']': return '[';
            default: return '\0';
        }
    }
}