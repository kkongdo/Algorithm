using System;

public class Solution {
    public int solution(int[,] sizes) {
        int answer = 0;
        int[] max = new int[2];
        
        // 1. 2차원 배열에서 각 배열의 첫번째 요소가 두번쩨 요소보다 큰 수가 오게 하도록 우선 만든다.
        // 2. 각 요소들끼리 각 비교.
        // 3. 제일 큰 가로와 세로 길이를 저장후 곱하기.

        for (int i = 0; i < sizes.GetLength(0); i++)
        {
            int cmrNum = sizes[i, 0];
            for (int j = 0; j < 2; j++)
            {
                if (cmrNum < sizes[i, 1])
                {
                    int tmp = sizes[i, 1];
                    sizes[i, 1] = cmrNum;
                    sizes[i, 0] = tmp;
                }
                if (max[0] < sizes[i, 0])
                max[0] = sizes[i, 0];

                if (max[1] < sizes[i, 1])
                max[1] = sizes[i, 1];
            }
            
    // 두 if문이 두번째 for문 내 있으면 안되는 이유 : 첫번째 요소가 두번째 요소보다 작을 경우 교환후 최대값 최소값을 비교해야되기때문. 
           
        }
        answer = max[0] * max[1];
        return answer;
    }
}