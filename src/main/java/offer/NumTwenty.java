package offer;

/**
 * @author FL8000
 * ��Ŀ������
 * ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
 * ���磬�ַ���"+100"��"5e2"��"-123"��"3.1416"��"-1E-16"��"0123"����ʾ��ֵ��
 * ��"12e"��"1a3.14"��"1.2.3"��"+-5"��"12e+5.4"�����ǡ�
 *
 * ---------------------------------------------------------------------------------------
 *
 * ������
 * ��ֵ���ַ���ģʽΪ��A[.[B]][eA] A��������λ
 * ��˿��Է�Ϊ�����ֽ����ж�
 *1��С����ǰ 2��С����-----ָ��ǰ   3��ָ����
 *��Ҫע����ǣ�һ����ֵֻ����һ��С���㣬�����ſ��Գ����ڵ�һλ��e�ĺ�һλ��eǰ�����Ҫ����ֵ
 */
public class NumTwenty {
    public boolean isNumber(String s) {
        //��Ϊ�пո�ĸ��ţ��Ȱѿո�ȥ�ˣ��ڽ��п�ָ���ж�
        s=s.trim();
        if(s==null||s.length()==0){
            return false;
        }
        //��ֵ�ж�
        boolean numFlag=false;
        //С�����ж�
        boolean dotFlag=false;
        //ָ���ж�
        boolean powFlag=false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<='9'&&s.charAt(i)>='0')
                numFlag=true;
                //��ʾֻ����һ�Σ�ͬʱ��������e֮��
            else if(s.charAt(i)=='.'&&!dotFlag&&!powFlag)
                dotFlag=true;
                //�ж��Ƿ��������e��ͬʱ�ж�eǰ���Ƿ���num
            else if((s.charAt(i)=='e'||s.charAt(i)=='E')&&!powFlag&&numFlag){
                powFlag=true;
                numFlag=false;
            }else if((s.charAt(i)=='+'||s.charAt(i)=='-')&&(i==0||s.charAt(i-1)=='e'||s.charAt(i-1)=='E')){

            }else{
                return false;
            }
        }
        return numFlag;
    }
}
