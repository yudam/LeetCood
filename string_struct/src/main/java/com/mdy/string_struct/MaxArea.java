package com.mdy.string_struct;

/**
 * TItle: 盛最多水的容器
 * Date: 2019/9/5
 * Time: 14:44
 */
public class MaxArea {

    public static void main(String[] args) {

        int[] rongqi = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea1(rongqi));
    }

    //两线段之间形成的区域总是会受到其中较短那条长度的限制。此外，两线段距离越远，得到的面积就越大。

    public static int maxArea(int[] height) {

        int maxarea = 0;

        for (int i = 1; i < height.length; i++) {
            for (int j = i + 1; j <= height.length; j++) {
                int width = j - i;
                int high = Math.min(height[i - 1], height[j - 1]);
                int currArea = width * high;
                maxarea = Math.max(maxarea, currArea);
            }
        }


        return maxarea;
    }


    /**
     * i、j表示首尾,s(i,j)=min(height[i],height[j])*(j-i)
     * 比较height[i],height[j]，来判断哪个是短板，哪个是长板。
     * 1.向内移动长板，会有三种情况，比之前的短板短，和之前的短板相等，和比之前的短板长（这种情况不需要考虑）
     * 比之前的短板短或者和之前的短板相等，那么s(i,j)肯定减小，因为高度减小和宽度都减小了。
     * 所以，移动长板面积一定比之前小。
     * <p>
     * 2.向内移动短板，会有三中情况：比之前长板长，比之前长板短，和之前长板相等。这三种情况每一种都可能使得s(i,j)
     * 增大，
     * <p>
     * 3.所以只有向内移动短板，才可以不遗漏每一种最大面积。
     */

    public static int maxArea1(int[] height) {

        int start = 0;
        int end = height.length - 1;
        int maxarea = 0;

        while (end > start) {
            int wid = end - start;
            int high = Math.min(height[start], height[end]);
            maxarea = Math.max(maxarea, wid * high);

            if (height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
        }
        return maxarea;
    }
}
