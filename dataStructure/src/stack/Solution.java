package stack;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if(temp == '(' || temp == '[' || temp == '{'){
                stack.push(temp);
            }
            else{
                if(stack.isEmpty())
                    return false;
                if(temp == ')' && stack.peek() != '(')
                    return false;
                if(temp == ']' && stack.peek() != '[')
                    return false;
                if(temp == '}' && stack.peek() != '{')
                    return false;
                stack.pop();
            }


        }
        return stack.isEmpty();
    }
}