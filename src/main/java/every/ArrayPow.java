package every;

public class ArrayPow {
    //双指针的思路
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
