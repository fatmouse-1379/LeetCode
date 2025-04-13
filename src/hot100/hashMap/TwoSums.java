package hot100.hashMap;

import java.util.HashMap;

/**
 * 001. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 * 20240720
 */
public class TwoSums {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ints = twoSum(nums, target);
        System.out.println("response"+ints.toString());
    }


    /**
     * 两数之和-暴力解法
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] response = new int[2];
        for (int i = 0; i < nums.length;i++) {
            for(int j = i+1;j <nums.length;j++) {
                if(nums[i]+nums[j] == target) {
                    response[0]=i;
                    response[1]=j;
                    return response;
                }
            }
        }
        return response;
    }

    /**
     * 两数之和-HashMAP解法
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        int[] response = new int[2];
        HashMap<Integer, Integer> complementMap = new HashMap<>();
        for (int i = 0; i < nums.length;i++) {
            int complement = target - nums[i];
            if (complementMap.containsKey(complement)) {
                response[0] = complementMap.get(complement);
                response[1] = i;
                return response;
            } else {
                complementMap.put(nums[i], i);
            }
        }
        return response;
    }
}