import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> phoneKet = new HashSet<Integer>();
        for(int phone : nums){
            phoneKet.add(phone);
        }
        if(phoneKet.size() <= nums.length / 2){
            return phoneKet.size();
        }else{
            return nums.length / 2;
        }
    }
}