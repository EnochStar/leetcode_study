package com.bjx.every;

/**
 * @author FL8000
 * ��Ŀ������
 * �����������ʹ�ü���������������name��ż�����ڼ����ַ�cʱ���������ܻᱻ���������ַ����ܱ����� 1 �λ��Ρ�
 * �㽫�������������ַ�typed���������Ӧ�Ŀ�����������ѵ����֣�����һЩ�ַ����ܱ�����������ô�ͷ���True��
 * ----------------------------------------------------------------------------------------------
 * ������
 * ����˫ָ��ķ�ʽ���ֱ�ָ��name��typed����ͬ����ƣ�����ͬ���ж�typed��ǰλ�õ�ֵ�Ƿ���ǰһ���±��ֵ��ͬ��
 * ע���±�Խ������Ĵ���
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
