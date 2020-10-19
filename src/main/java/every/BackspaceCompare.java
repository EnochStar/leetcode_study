package every;

/**
 * @author FL8000
 * ��Ŀ���������� S �� T �����ַ����������Ƿֱ����뵽�հ׵��ı��༭�����ж϶����Ƿ���ȣ������ؽ���� # �����˸��ַ���
 *
 * ע�⣺����Կ��ı������˸��ַ����ı�����Ϊ�ա�
 *
 * ---------------------------------------------------------
 *
 * ������
 * ���ַ���  1���ع���ʹ��StringBuilder�����˸������Ȼ����бȽ�
 *         2��˫ָ�롣ʹ�������˸�����Ƕ�ǰ����ַ������޸ģ���˿��ԴӺ���ǰ���бȽϡ�
 *         ��skip�����洢�˸�Ĵ������õ�ַ�±�洢��ǰָ���λ��
 *         3��ջ��
 *
 *  https://leetcode-cn.com/problems/backspace-string-compare/
 */
public class BackspaceCompare {
    // �ع�
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
    // ˫ָ��
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
