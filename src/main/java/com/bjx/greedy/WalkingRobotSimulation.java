package com.bjx.greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author EnochStar
 * @title: WalkingRobotSimulation
 * @projectName leetcode_study
 * @description: 
 * ��������һ�����޴�С�� XY ����ƽ�������ߣ��ӵ� (0, 0) ����ʼ���������򱱷����û����˿��Խ��������������͵����� commands ��
 *
 * -2 ������ת 90 ��
 * -1 ������ת 90 ��
 * 1 <= x <= 9 ����ǰ�ƶ� x ����λ����
 * ����������һЩ���ӱ���Ϊ�ϰ��� obstacles ���� i ���ϰ���λ�������  obstacles[i] = (xi, yi) ��
 *
 * �������޷��ߵ��ϰ����ϣ�������ͣ�����ϰ����ǰһ�����񷽿��ϣ�����Ȼ���Լ������Խ��и�·�ߵ����ಿ�֡�
 *
 * ���ش�ԭ�㵽���������о�����·���㣨����Ϊ�����������ŷʽ�����ƽ�����������������Ϊ 5 ���򷵻� 25 ��
 *
 *  
 * ע�⣺
 *
 * ����ʾ +Y ����
 * ����ʾ +X ����
 * �ϱ�ʾ -Y ����
 * ����ʾ -X ����
 *  
 *
 * ʾ�� 1��
 *
 * ���룺commands = [4,-1,3], obstacles = []
 * �����25
 * ���ͣ�
 * �����˿�ʼλ�� (0, 0)��
 * 1. ���ƶ� 4 ����λ������ (0, 4)
 * 2. ��ת
 * 3. ���ƶ� 3 ����λ������ (3, 4)
 * ����ԭ����Զ���� (3, 4) ������Ϊ 32 + 42 = 25
 * ʾ�� 2��
 *
 * ���룺commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * �����65
 * ���ͣ������˿�ʼλ�� (0, 0)��
 * 1. ���ƶ� 4 ����λ������ (0, 4)
 * 2. ��ת
 * 3. ���ƶ� 1 ����λ��Ȼ��λ�� (2, 4) ���ϰ����赲��������ͣ�� (1, 4)
 * 4. ��ת
 * 5. ���� 4 ����λ������ (1, 8)
 * ����ԭ����Զ���� (1, 8) ������Ϊ 12 + 82 = 65
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/walking-robot-simulation
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/2/20 11:32
 */
public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0,y = 0,result = 0;
        Set<String> set = new HashSet();
        for(int[] obs : obstacles) {
            set.add(obs[0] + "," + obs[1]);
        }
        int[] dx = new int[] {0,1,0,-1};
        int[] dy = new int[] {1,0,-1,0};
        int direction = 0;
        for(int com : commands) {
            if(com == -2) {
                direction = (direction + 3) % 4;
            }else if(com == -1) {
                direction = (direction + 1) % 4;
            }else{
                for(int i = 1;i <= com;i++) {
                    x = dx[direction] + x;
                    y = dy[direction] + y;
                    if(set.contains(x + "," + y))
                        break;
                }
                result = Math.max(result,x * x + y * y);
            }
        }
        return result;
    }
}
