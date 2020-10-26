package offer;

/**
 * @author FL8000
 * 题目描述：
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *
 * ---------------------------------------------------------------------------------------
 *
 * 分析：
 * 数值的字符串模式为：A[.[B]][eA] A包含符号位
 * 因此可以分为三部分进行判断
 *1、小数点前 2、小数点-----指数前   3、指数后
 *需要注意的是：一段数值只包含一个小数点，正负号可以出现在第一位和e的后一位，e前后必须要有数值
 */
public class NumTwenty {
    public boolean isNumber(String s) {
        //因为有空格的干扰，先把空格去了，在进行空指针判断
        s=s.trim();
        if(s==null||s.length()==0){
            return false;
        }
        //数值判断
        boolean numFlag=false;
        //小数点判断
        boolean dotFlag=false;
        //指数判断
        boolean powFlag=false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<='9'&&s.charAt(i)>='0')
                numFlag=true;
                //表示只出现一次，同时不出现在e之后
            else if(s.charAt(i)=='.'&&!dotFlag&&!powFlag)
                dotFlag=true;
                //判断是否存在两个e，同时判断e前面是否有num
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
