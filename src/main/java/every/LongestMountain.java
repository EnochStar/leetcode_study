package every;

/**
 * @author FL8000
 * ��Ŀ���������ǰ����� A �з����������Ե��������������� B ��Ϊ ��ɽ������
 *
 * B.length >= 3
 * ���� 0 < i< B.length - 1 ʹ�� B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * ��ע�⣺B ������ A �����������飬������������ A����
 *
 * ����һ���������� A������� ��ɽ�����ĳ��ȡ�
 *
 * ��������� ��ɽ�����򷵻� 0��
 *
 * -----------------------------------------------------------------------------------------------------
 * ������˫ָ�뷽ʽ��������ڶ����������ڶ���Ϊɽ���������ж��䳤��
 */
public class LongestMountain {
    public int longestMountain(int[] A) {
        // ˫ָ��
        // �߽�
        int len = A.length;
        int ans = 0;
        if (len<3){
            return 0;
        }
        for (int i = 1; i < len-1; i++) {
            int l = i-1, r = i+1;
            if (A[i]>A[l]&&A[i]>A[r]){
                while(l>0&&A[l]>A[l-1]){
                    l--;
                }
                while(r<len-1&&A[r]>A[r+1]){
                    r++;
                }
                ans = Math.max(ans,r-l+1);
            }
        }
        return ans;
    }
}
