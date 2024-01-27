import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Deque<Integer> list = new ArrayDeque<Integer>();
        Arrays.sort(nums);
        list.offer(nums[0]);
        int count = nums.length / 2;
        for(int i = 1; i < nums.length; i++){
            if(count == list.size()){
                break;
            }
            if(nums[i] != list.peekLast()){
                list.offer(nums[i]);
            }
        }
        return list.size();
    }
}