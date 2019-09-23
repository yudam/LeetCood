package com.mdy.string_struct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 */
public class Solution17 {


    public static void main(String[] args) {

        List<String> response = letterCombinations3("223");

        for (String s : response) {
            System.out.print(s + " ");
        }

    }


    /**
     * 两个变量放在方法里面完全是因为LeetCode所有的自定义变量只能放在方法中。
     * 1.转化成从根节点到每一个叶子结点的路径。
     * 2.采用递归的方法来遍历每一层的子节点
     */

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<String, String> phone = new HashMap<String, String>() {
            {
                put("2", "abc");
                put("3", "def");
                put("4", "ghi");
                put("5", "jkl");
                put("6", "mno");
                put("7", "pqrs");
                put("8", "tuv");
                put("9", "wxyz");
            }
        };

        if (digits.isEmpty()) return result;
        letterCombinations2(result, phone, "", digits);
        return result;
    }

    public static void letterCombinations2(List<String> result, Map<String, String> phone, String componet, String digits) {

        if (digits.length() == 0) {
            result.add(componet);
            return;
        }
        String subString = digits.substring(0, 1);
        String phoneZm = phone.get(subString);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < phoneZm.length(); i++) {
            stringBuffer.delete(0, stringBuffer.length());
            stringBuffer.append(componet).append(phoneZm.charAt(i));
            String lastString = digits.substring(1);
            letterCombinations2(result, phone, stringBuffer.toString(), lastString);
        }
    }


    /**
     * 利用队列的先进先出，删除先出，拼接后重新添加到队列中
     */

    public static List<String> letterCombinations3(String digits) {

        LinkedList<String> linkedList = new LinkedList<>();
        if (digits.isEmpty()) return linkedList;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        linkedList.add("");
        for (int i = 0; i < digits.length(); i++) {
            while (linkedList.peek().length() == i) {
                int index = Character.getNumericValue(digits.charAt(i));
                String t = linkedList.remove();
                for (char s : mapping[index].toCharArray()) {
                    linkedList.add(t + s);
                }
            }

        }
        return linkedList;
    }
}
