package hot100.subString;

import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 */
public class MaxSlidingWindow {
    public static void main(String[] args)
    {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        for (int i : res)
        {
            System.out.println(i);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        LinkedList<Integer> maxQueue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // 移除超出滑动窗口的值
            while (!maxQueue.isEmpty() && maxQueue.peek() <= i - k) {
                maxQueue.poll();
            }

            // 移除比当前队列还小的值（新人最弱）
            while (!maxQueue.isEmpty() && nums[maxQueue.peekLast()] <= nums[i]) {
                maxQueue.pollLast();
            }

            maxQueue.offer(i);
            if (i >= k - 1) {
                ans[i - k + 1] = nums[maxQueue.peek()];
            }
        }
        return ans;
    }
}
