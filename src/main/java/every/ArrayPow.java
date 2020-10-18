package every;

/**
 * @author FL8000
 * 题目分析：
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *
 * ----------------------------------------------------------------------------
 * 思路1、第一次遍历将负数取反，然后调用Arrays.sort()函数排序。时间复杂度O（nlogn）
 * 思路2、双指针思路，将头指针和尾指针标识的数的平方进行比较，新建一个数组进性存储。时间复杂度O（n）
 *
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class ArrayPow {
    
/**
 * @author FL8000
 * 棰樼洰鍒嗘瀽锛�
 * 缁欏畾涓�涓寜闈為�掑噺椤哄簭鎺掑簭鐨勬暣鏁版暟缁� A锛岃繑鍥炴瘡涓暟瀛楃殑骞虫柟缁勬垚鐨勬柊鏁扮粍锛岃姹備篃鎸夐潪閫掑噺椤哄簭鎺掑簭銆�
 *
 *
 * ----------------------------------------------------------------------------
 * 鎬濊矾1銆佺涓�娆￠亶鍘嗗皢璐熸暟鍙栧弽锛岀劧鍚庤皟鐢ˋrrays.sort()鍑芥暟鎺掑簭銆傛椂闂村鏉傚害O锛坣logn锛�
 * 鎬濊矾2銆佸弻鎸囬拡鎬濊矾锛屽皢澶存寚閽堝拰灏炬寚閽堟爣璇嗙殑鏁扮殑骞虫柟杩涜姣旇緝锛屾柊寤轰竴涓暟缁勮繘鎬у瓨鍌ㄣ�傛椂闂村鏉傚害O锛坣锛�
 *
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */路
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
