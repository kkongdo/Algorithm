public class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        double tmp=0;
        if(arr.Length>=1 && arr.Length<=100)
        {
            for(int i=0;i<arr.Length; i++)
            {
                if(arr[i] >= -10000 && arr[i] <= 10000)
                {
                    tmp+=arr[i];
                }   
            }
            answer=tmp/arr.Length;
        }
        return answer;
    }
}