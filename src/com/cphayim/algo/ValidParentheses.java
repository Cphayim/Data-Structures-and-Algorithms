package com.cphayim.algo;

/**
 * @author Cphayim
 * @date Created in 2018/6/5 00:11
 */

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 *   1.左括号必须用相同类型的右括号闭合。
 *   2.左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串
 *
 * 例1.
 *   输入: "()"
 *   输出: true
 *
 * 例2.
 *   输入: "()[]{}"
 *   输出: true
 *
 * 例3.
 *   输入: "(]"
 *   输出: false
 *
 * 例4.
 *   输入: "([)]"
 *   输出: false
 *
 * 例5.
 *   输入: "{[]}"
 *   输出: true
 */

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                char topChar = stack.pop();

                if (c == ')' && topChar != '(')
                    return false;
                if (c == ']' && topChar != '[')
                    return false;
                if (c == '}' && topChar != '{')
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("()[]{}"));
    }
}
