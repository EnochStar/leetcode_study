package every;

import java.util.*;

/**
 * @author FL8000
 * ��Ŀ����������һ���ǿ��ַ��� s ��һ�������ǿյ����б���ֵ� wordDict�����ַ��������ӿո�������һ�����ӣ�ʹ�þ��������еĵ��ʶ��ڴʵ��С�����������Щ���ܵľ��ӡ�
 *
 * ˵����
 *
 * �ָ�ʱ�����ظ�ʹ���ֵ��еĵ��ʡ�
 * ����Լ����ֵ���û���ظ��ĵ��ʡ�
 *
 * ���ӣ�https://leetcode-cn.com/problems/word-break-ii
 *
 * ������ ̫������������copy���е�
 * https://leetcode-cn.com/problems/word-break-ii/solution/dong-tai-gui-hua-hui-su-qiu-jie-ju-ti-zhi-python-d/
 */
public class WordBreakTwo {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        // Ϊ�˿����ж�һ�������Ƿ��ڵ��ʼ����У���Ҫ�����Ǽ����ϣ��
        Set<String> wordSet = new HashSet<>(wordDict);
        int len = s.length();

        // �� 1 ������̬�滮�����Ƿ��н�
        // dp[i] ��ʾ�����ȡ�Ϊ i �� s ǰ׺�Ӵ����Բ�ֳ� wordDict �еĵ���
        // ���Ȱ��� 0 �����״̬����ĳ���Ϊ len + 1
        boolean[] dp = new boolean[len + 1];
        // 0 ���ֵ��Ҫ�������״ֵ̬�ο������һ������������ wordDict �У�dp[0] ���ó� true �Ǻ����
        dp[0] = true;

        for (int right = 1; right <= len; right++) {
            // ������ʼ����еĵ��ʳ��ȶ��������Ӻ���ǰ�����Ǹ����
            for (int left = right - 1; left >= 0; left--) {
                // substring ����ȡ s[right]��dp[left] �Ľ�������� s[left]
                if (wordSet.contains(s.substring(left, right)) && dp[left]) {
                    dp[right] = true;
                    // ��� break ����Ҫ��һ���õ� dp[right] = True �������ټ�����ȥ
                    break;
                }
            }
        }

        // �� 2 ���������㷨�������з��������Ľ�
        List<String> res = new ArrayList<>();
        if (dp[len]) {
            Deque<String> path = new ArrayDeque<>();
            dfs(s, len, wordSet, dp, path, res);
            return res;
        }
        return res;
    }

    /**
     * s[0:len) ������Բ�ֳ� wordSet �еĵ��ʣ��ѵݹ����Ľ������ res ��
     *
     * @param s
     * @param len     ����Ϊ len �� s ��ǰ׺�Ӵ�
     * @param wordSet ���ʼ��ϣ��Ѿ������ϣ��
     * @param dp      Ԥ����õ��� dp ����
     * @param path    ��Ҷ�ӽ�㵽������·��
     * @param res     �������н���ı���
     */
    private static void dfs(String s, int len, Set<String> wordSet, boolean[] dp, Deque<String> path, List<String> res) {
        if (len == 0) {
            res.add(String.join(" ",path));
            return;
        }

        // ���Բ�ֵ���߽�� len - 1 ����ö�ٵ� 0
        for (int i = len - 1; i >= 0; i--) {
            String suffix = s.substring(i, len);
            if (wordSet.contains(suffix) && dp[i]) {
                path.addFirst(suffix);
                dfs(s, i, wordSet, dp, path, res);
                path.removeFirst();
            }
        }
    }

    public static void main(String[] args) {
        String word = "catsanddog";
        String[] wordDict = new String[]{"cat", "cats", "and", "sand", "dog"};
        List<String> list = Arrays.asList(wordDict);
        wordBreak(word,list);
    }
}
