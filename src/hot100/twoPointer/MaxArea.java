package hot100.twoPointer;

/**
 * 11. 盛最多水的容器-中等
 * 提示
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 *
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 */
public class MaxArea {

    public static void main(String[] args)
    {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }


    public static int maxArea(int[] height) {
        // 宽最宽，高最高
        int maxArea = 0;
        // 分别从左边和右边各来一个指针，然后往中间走
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if (area > maxArea) {
                maxArea = area;
            } else {
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return maxArea;
    }


}
