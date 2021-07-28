package com.dylan.solvecode;

import cn.hutool.json.JSONUtil;

import java.util.*;

/**
 * 字符串分割
 *
 * @author wudelong
 * @Date 2021/6/21 20:32
 */
public class WordBreak {

    public static void main(String[] args) {


        System.out.println(JSONUtil.toJsonStr(wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog"))));
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {

        List<String> result = new ArrayList();
        process(s, new HashSet(wordDict), 0, "", result);
        return result;
    }

    public static void process(String s, Set<String> wordDict, int p, String tmp, List<String> result) {

        if(p == s.length() ) {
            result.add(tmp.trim());
            return;
        }

        for(int i = p; i <= s.length(); i++) {
            if(!wordDict.contains(s.substring(p, i))) {
                continue;
            } else {
                process(s, wordDict, i, tmp + " " + s.substring(p,i), result);
            }
        }
    }
}
