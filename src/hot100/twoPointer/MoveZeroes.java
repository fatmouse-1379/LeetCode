package hot100.twoPointer;

import java.util.HashMap;

/**
 * 283. 移动零-简单
 * 提示
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 移动数组中的零到尾部。
     * 通过使用HashMap记录零的位置，然后重新排列数组元素，将零移动到数组的末尾。
     * 这种方法避免了直接对数组进行多次遍历，提高了效率。
     *
     * @param nums 输入的整数数组，该数组会被就地修改。
     */
    public static void moveZeroes(int[] nums) {
        // 使用HashMap记录每个零的位置
        // 记录下0所在的位置
        HashMap<Integer, Integer> zeroNums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNums.put(i, 0);
            }
        }

        int nextFlag = 0;
        // 遍历数组，重新排列非零元素
        for (int i = 0; i < nums.length; i++) {
            if (!zeroNums.containsKey(i)) {
                nums[i - nextFlag] = nums[i];
            } else {
                nextFlag++;
            }
        }

        int size = zeroNums.size();
        // 将剩余的位置填充为零
        if (size > 0) {
            for (int i = nums.length - size; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }

    public static void moveZeroes2(int[] nums) {
        // 检查输入数组是否为null，防止NullPointerException
        if (nums == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }

        int nonZeroPos = 0; // 非零元素的当前位置

        // 第一次遍历，将非零元素向数组前部移动
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroPos++] = nums[i];
            }
        }

        // 第二次遍历，将剩余位置置为0
        for (; nonZeroPos < nums.length; nonZeroPos++) {
            nums[nonZeroPos] = 0;
        }
    }

    /**
     * 官方解法
     * 方法一：双指针
     * 思路及解法
     * 使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
     * 右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
     * 注意到以下性质：
     * 左指针左边均为非零数；
     * 右指针左边直到左指针处均为零。
     * 因此每次交换，都是将左指针的零与右指针的非零数交换，且非零数的相对顺序并未改变。
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
