package hot100.hashMap;

import java.util.Arrays;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 */
public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {1,2,0,1};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        // 检查输入数组是否为null
        if (nums == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }

        // 数组长度为0或1时，直接返回长度
        if (nums.length <= 1) {
            return nums.length;
        }

        // 初始化当前递增子序列长度和最长递增子序列长度
        int currentStreak = 1;
        int maxStreak = 1;

        // 对数组进行排序
        Arrays.sort(nums);

        // 遍历数组，寻找最长递增子序列
        for (int i = 1; i < nums.length; i++) {
            int difference = nums[i] - nums[i-1];

            // 如果当前数字与前一个数字递增，增加当前递增子序列长度
            if (difference == 1) {
                currentStreak++;
                // 更新最长递增子序列长度
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                }
            }
            // 如果当前数字与前一个数字相同，保持当前递增子序列长度
            else if (difference == 0) {
                continue;
            }
            // 如果当前数字与前一个数字减少，重置当前递增子序列长度
            else {
                currentStreak = 1;
            }
        }
        // 返回最长递增子序列的长度
        return maxStreak;
    }


}
