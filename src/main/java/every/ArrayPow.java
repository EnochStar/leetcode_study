package every;

/**
 * @author FL8000
 * ��Ŀ������
 * ����һ�����ǵݼ�˳��������������� A������ÿ�����ֵ�ƽ����ɵ������飬Ҫ��Ҳ���ǵݼ�˳������
 *
 *
 * ----------------------------------------------------------------------------
 * ˼·1����һ�α���������ȡ����Ȼ�����Arrays.sort()��������ʱ�临�Ӷ�O��nlogn��
 * ˼·2��˫ָ��˼·����ͷָ���βָ���ʶ������ƽ�����бȽϣ��½�һ��������Դ洢��ʱ�临�Ӷ�O��n��
 *
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class ArrayPow {
    //˫ָ���˼·
    public int[] sortedSquares(int[] A) {
        int n=A.length;
        int[] ans=new int[n];
        int p=n-1;
        for(int i=0,j=n-1;i<=j;){
            if(A[i]*A[i]>A[j]*A[j]){
                ans[p]=A[i]*A[i];
                i++;
            }else{
                ans[p]=A[j]*A[j];
                j--;
            }
            p--;
        }
        return  ans;
    }
}
