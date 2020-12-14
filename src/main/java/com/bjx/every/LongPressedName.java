package com.bjx.every;

/**
 * @author FL8000
 * 题目分析：
 * 你的朋友正在使用键盘输入他的名字name。偶尔，在键入字符c时，按键可能会被长按，而字符可能被输入 1 次或多次。
 * 你将会检查键盘输入的字符typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回True。
 * ----------------------------------------------------------------------------------------------
 * 分析：
 * 采用双指针的方式，分别指向name和typed，相同则后移，不相同则判断typed当前位置的值是否与前一个下标的值相同。
 * 注意下标越界问题的处理。
 */
public class LongPressedName {
    public static boolean isLongPressedName(String name, String typed) {
        int nLen = name.length();
        int tLen = typed.length();
        if(tLen < nLen || name.charAt(0) != typed.charAt(0)){
            return false;
        }
        int index_n = 0;
        int index_t = 0;

        while(index_n < nLen && index_t < tLen){
            if(name.charAt(index_n) == typed.charAt(index_t)){
                index_n++;
                index_t++;
            }else{
                if(typed.charAt(index_t) == typed.charAt(index_t-1)){
                    while(index_t < tLen && typed.charAt(index_t) == typed.charAt(index_t-1)){
                        index_t++;
                    }
                }else{
                    return false;
                }
            }
            if(index_t == tLen && index_n < nLen){
                return false;
            }
            if(index_n == nLen){
                while(tLen > index_t + 1){
                    if(typed.charAt(index_t) != typed.charAt(index_t + 1)){
                        return false;
                    }
                    index_t++;
                }
            }
        }
        return true;
    }
}
