package every;

/**
 * @author FL8000
 * 题目描述：给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 * ---------------------------------------------------------
 *
 * 分析：
 * 三种方法  1、重构。使用StringBuilder进行退格操作，然后进行比较
 *         2、双指针。使用由于退格操作是对前面的字符进行修改，因此可以从后往前进行比较。
 *         用skip变量存储退格的次数，用地址下标存储当前指向的位置
 *         3、栈。
 *
 *  https://leetcode-cn.com/problems/backspace-string-compare/
 */
public class BackspaceCompare {
    // 重构
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }
    public String build(String s){
        StringBuilder res = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == '#'){
                if(res == null || res.toString().equals("")){
                    continue;
                }else{
                    res.deleteCharAt(res.length()-1);
                }
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
    // 双指针
    // public boolean backspaceCompare(String S, String T) {
    //     int i = S.length() - 1, j = T.length() - 1;
    //     int skipS = 0, skipT = 0;
    //     while(i >= 0 || j >= 0){
    //         while(i >= 0){
    //             if(S.charAt(i) == '#'){
    //                 skipS++;
    //                 i--;
    //             }else if(skipS > 0){
    //                 i--;
    //                 skipS--;
    //             }else{
    //                 break;
    //             }
    //         }
    //         while (j >= 0){
    //             if (T.charAt(j) == '#'){
    //                 skipT++;
    //                 j--;
    //             }else if (skipT > 0){
    //                 j--;
    //                 skipT--;
    //             }else {
    //                 break;
    //             }
    //         }
    //         if (i >= 0 && j >= 0){
    //             if (S.charAt(i) != T.charAt(j)){
    //                 return false;
    //             }
    //         }else{
    //             if (i >= 0 || j >= 0){
    //                 return false;
    //             }
    //         }
    //         i--;
    //         j--;
    //     }
    //     return true;
    // }
}
