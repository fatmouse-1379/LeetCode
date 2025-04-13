package hot100.twoPointer;

import java.util.*;

/**
 * 15. 三数之和-中等
 * 提示
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        // 检查边界条件
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        // 对数组进行排序
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int k = 2; k < nums.length; k++) {
            int i = 0;
            int j = k - 1;
            // 固定k，使用双指针技术查找三元组
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果三元组和为0，添加到结果集
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    // 优化：跳过重复元素
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                } else if (nums[i]+nums[j]+nums[k]<0){
                    i++;
                } else {
                    j--;
                }
            }

        }
        return new ArrayList<>(result);
    }
}
