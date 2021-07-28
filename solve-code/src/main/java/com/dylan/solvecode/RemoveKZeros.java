package com.dylan.solvecode;

/**
 * 移除k个0
 *
 * @author wudelong
 * @Date 2021/6/21 10:55
 */
public class RemoveKZeros {

    public static void main(String[] args) {

        String str = "  A00  0B00  ";
        System.out.println(str.trim());
//        System.out.println(removeKZeros(str, 3));
    }


    public static String removeKZeros(String str, int k) {

        char[] chars = str.toCharArray();
        int count = 0;
        int start = -1;



        for (int i = 0; i< chars.length; i++) {

            if (chars[i] == '0') {
                count++;
                start = start == -1 ? i : start;
            } else {
                if (count == k) {
                    while (count-- != 0) {
                        chars[start++] = 0;
                    }
                }
                start = -1;
                count = 0;
            }
        }

        if (count == k) {
            while (count-- != 0) {
                chars[start++] = 0;
            }
        }
        return String.valueOf(chars);
    }
}
