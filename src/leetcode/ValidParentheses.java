package leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValidParentheses(String s) {
        HashMap<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (bracketMap.containsKey(c)) {
                if (stack.isEmpty()) return false; //-- if stack is empty, nothing to match

                char topElement = stack.pop();

                if (topElement != bracketMap.get(c)) return false;
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static boolean isValidParenthesesStack(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false; //-- we have nothing to close

                char open = stack.pop();
                if ((c == ')') && open != '(' || (c == '}') && open != '{' || (c == ']') && open != '[') {
                    return false;
                }
            }
        }


        return stack.isEmpty(); //-- all opened parentheses must be closed
    }

    public static void main(String[] args) {
        boolean valid = isValidParenthesesStack("(){}");
        if (valid) {
            System.out.println("Yes, it is");
        } else {
            System.out.println("No, it isn't");
        }
    }
}
