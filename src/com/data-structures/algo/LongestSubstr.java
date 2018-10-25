package com.cphayim.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cphayim
 * @date Created in 2018/6/8 14:20
 */

/**
 * 无重复字符的最长子串
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 *
 * 示例：
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 */
public class LongestSubstr {

    public int lengthOfLongestSubString(String s) {

        // 将当前遍历字符串遇到的无重复的字符以及它的索引作为键值存入 HashMap
        Map<Character, Integer> map = new HashMap<>();

        // 保存最大长度子串长度
        int lengthOfLongest = 0;
        int currentLength = 0;

        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            // 如果当前字符存在于 HashMap 中
            if (map.containsKey(c)) {
                // 将 index 设为 HashMap 取出的索引的后一位 ("swsa" 即第二次遇到 s 时，将 index 设置为 1，从 w 重新计算一个新的子串长度)
                index = map.get(c) + 1;
                // 更新最大长度的值
                lengthOfLongest = currentLength > lengthOfLongest ? currentLength : lengthOfLongest;
                // 重置当前长度并清空 HashMap
                currentLength = 0;
                map.clear();
            }
            map.put(c, index);
            currentLength++;
            index++;
        }

        // 更新最大长度的值
        lengthOfLongest = currentLength > lengthOfLongest ? currentLength : lengthOfLongest;

        return lengthOfLongest;
    }

    public static void main(String[] args) {
        LongestSubstr ls = new LongestSubstr();
        System.out.println(ls.lengthOfLongestSubString("abcabcbb"));
        System.out.println(ls.lengthOfLongestSubString("bbbbb"));
        System.out.println(ls.lengthOfLongestSubString("pwwkew"));
        System.out.println(ls.lengthOfLongestSubString("pvpw"));
    }
}
