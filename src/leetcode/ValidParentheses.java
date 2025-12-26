package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s){
        HashMap<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){
            if (bracketMap.containsKey(c)) {
                if(stack.isEmpty()) return false; //-- if stack is empty, nothing to match

                char topElement = stack.pop();

                if(topElement != bracketMap.get(c)) return false;
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean valid = isValid("(){}");
        if(valid){
            System.out.println("Yes, it is");
        } else {
            System.out.println("No, it doesn't");
        }
    }
}
