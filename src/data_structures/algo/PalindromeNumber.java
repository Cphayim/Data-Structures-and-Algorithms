package com.cphayim.algo;

/**
 * @author Cphayim
 * @date Created in 2018/6/10 22:29
 */

/**
 * 回文数
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 * 输入: 121
 * 输出: true
 *
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {

        /**
         * 特殊情况判断
         * 1. x < 0
         * 2. x 不等于 0 但 x 的个位数是 0
         * 都可以直接断定 x 不是回文数
         */
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        /**
         * 将 x 分成两半，对右边的一半进行反转后比较是否与左边的相等
         * 例如将 1221 分成 12 与 21，将 21 反转后得到 12，12 == 12 所以 1221 是回文数
         */

        // 存放反转的数字
        int revertedNumber = 0;

        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        /**
         * 当 x 传入时长度是奇数（如 12321），此时的 x 是 12，revertedNumber 是 123
         * 将 revertedNumber / 10 排除中间数后再比较
         */
        return x == revertedNumber || x == revertedNumber / 10;

    }

    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();
        System.out.println("1221: " + pn.isPalindrome(1221));
        System.out.println("12321: "+ pn.isPalindrome(12321));
        System.out.println("982321: "+ pn.isPalindrome(982321));
        System.out.println("1: "+ pn.isPalindrome(1));
        System.out.println("10: "+ pn.isPalindrome(10));
        System.out.println("-1331: "+ pn.isPalindrome(10));
    }
}
