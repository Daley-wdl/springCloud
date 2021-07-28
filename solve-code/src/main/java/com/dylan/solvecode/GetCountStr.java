package com.dylan.solvecode;

import cn.hutool.json.JSONUtil;

import java.util.concurrent.CountDownLatch;

/**
 * @author wudelong
 * @Date 2021/6/22 10:54
 */
public class GetCountStr {

    public static void main(String[] args) {
        System.out.println(JSONUtil.toJsonStr(getCountStr("aaabbaddfffe")));
    }


    public static String getCountStr(String str) {

        String result = "";
        char curr = str.charAt(0);
        Integer count = 0;


        for (int i = 0; i< str.length(); i++) {

            if (curr == str.charAt(i)) {
                count++;
            } else {
                result+= curr + "_" + count + "_";
                count = 1;
                curr = str.charAt(i);
            }
        }

        result += curr + "_" + count;


        return result;
    }

}
