package com.dylan.solvecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wudelong
 * @Date 2021/6/22 21:03
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(process("tmmzuxt"));
    }

    public static int process(String s) {

        Map<Integer, Integer> map = new HashMap();
        int start = -1;
        int max = 0;

        for(int i = 0; i< s.length(); i++) {
            if(map.containsKey(s.charAt(i) - 'a')) {
                Integer index = map.get(s.charAt(i) - 'a');
                map.put(s.charAt(i) - 'a', i);
                start = index + 1;

            } else {
                map.put(s.charAt(i) - 'a', i);
                start = start == -1? i : start;
                max = i - start + 1;
            }
        }
        System.out.println("start:" + start + ", max:"+max);
        return max;
    }
}
