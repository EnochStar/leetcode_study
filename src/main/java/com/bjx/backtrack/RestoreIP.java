package com.bjx.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author EnochStar
 * @title: RestoreIP
 * @projectName leetcode_study
 * @description: 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 *
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 *
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/620:54
 */
public class RestoreIP {
    List<String> res = new ArrayList();
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        if(len < 4 || len > 12) {
            return res;
        }
        backtrack(s, len, 0, 4, new LinkedList());
        return res;
    }
    void backtrack(String s, int len, int begin, int residue, LinkedList<String> list) {
        if(begin == len) {
            if(residue == 0) {
                res.add(String.join(".",list));
            }
            return;
        }
        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) break;
            if (residue * 3 < len - i) break;
            if (judgeIPSegment(s,begin,i)) {
                String temp = s.substring(begin,i + 1);
                list.addLast(temp);
                backtrack(s,len,i + 1, residue - 1, list);
                list.removeLast();
            }
        }
    }
    boolean judgeIPSegment(String s, int left, int right) {
        int len = right - left + 1;
        int num = 0;
        if (len > 1 && s.charAt(left) == '0') return false;
        while (left <= right) {
            num = num * 10 + s.charAt(left) - '0';
            left++;
        }
        return num >= 0 && num <= 255;
    }
    //国外大佬的暴力美学
    public List<String> restoreIpAddresses_zero(String s) {
        List<String> ret = new ArrayList<>();

        StringBuilder ip = new StringBuilder();

        for(int a = 1 ; a < 4 ; ++ a)
            for(int b = 1 ; b < 4 ; ++ b)
                for(int c = 1 ; c < 4 ; ++ c)
                    for(int d = 1 ; d < 4 ; ++ d)
                    {
                        if(a + b + c + d == s.length() )
                        {
                            int n1 = Integer.parseInt(s.substring(0, a));
                            int n2 = Integer.parseInt(s.substring(a, a+b));
                            int n3 = Integer.parseInt(s.substring(a+b, a+b+c));
                            int n4 = Integer.parseInt(s.substring(a+b+c));
                            if(n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255)
                            {
                                ip.append(n1).append('.').append(n2)
                                        .append('.').append(n3).append('.').append(n4);
                                //010 parseInt 10 的判断
                                if(ip.length() == s.length() + 3) ret.add(ip.toString());
                                ip.delete(0, ip.length());
                            }
                        }
                    }
        return ret;
    }
}
