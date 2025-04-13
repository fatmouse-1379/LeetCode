package hot100.subString;

import java.util.HashMap;

/**
 * 560. 和为 K 的子数组-中等
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 *
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 */
public class SubarraySum {

    public static void main(String[] args) {
        int[] nums = {-2,-1,1};
        System.out.println(subarraySum2(nums, 0));
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int endIndex = 0; endIndex < nums.length; endIndex++) {
            int sum = 0;
            for (int startIndex = endIndex; startIndex >= 0; startIndex--) {
                sum += nums[startIndex];
                if (sum==k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int subarraySum2(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap< >();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
