package com.mdy.sort;

public class MyClass {

    public static void main(String[] args) {

//        int[] nums = new int[]{5, 2, 8, 3, 1, 7, 6, 4};
//        mergeSort(nums);
//        looger(nums);

        final StringBuilder stringBuilder =new StringBuilder();
        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<1000;i++){
                        stringBuilder.append("a");
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("len="+stringBuilder.length());
    }

    /**
     * 5, 2, 8, 3, 1, 7, 6, 4
     *
     * 5, 2, 8, 3               1, 7, 6, 4
     *
     * 5, 2    8, 3              1, 7    6, 4
     *
     * 5  2  8  3               1   7   6   4
     */

    /**
     * 归并排序思想：
     * 1.采用而分治法的思路：把待排序的表分为若干合子序列表，保证每一个子序列表是有序的，在合并有序的子序列表。
     * 2.创建一个大小为原数组大小的空间，用来存放子序列排序后的元素。
     * 3.采用两个指针start和end，分别指向两个子序列的表头
     * 4.移动指针，从表头开始比较两个子序列的元素大小，较小的元素放入合并空间，移动到下一个指针。
     * 5.将合并空间中的元素替换到原始数组中。
     * <p>
     * 注：通过迭代法，迭代到最小的元素，
     */

    private static void mergeSort(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        if (start >= end) return;
        int[] result = new int[end - start + 1];
        mergeChild(nums, result, start, end);
    }


    private static void mergeChild(int[] nums, int[] result, int start, int end) {
        if (start >= end) return;
        int mid = (end + start) / 2;

        mergeChild(nums, result, start, mid);
        mergeChild(nums, result, mid + 1, end);

        int i = start;
        int j = mid + 1;
        int k = start;
        //可以看成是一个子序列(以mid为中间线，左右两边分别是有序的)，也可以是两个有序的子序列
        //这里循环肯定有一个子序列可以完全合并到合并空间中，剩余的一个子序列剩余的元素还是有序的，所以直接放入就可以了.
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                result[k++] = nums[i++];
            } else {
                result[k++] = nums[j++];
            }
        }

        //把剩余的元素依次放入合并空间，此时一定是有序的
        while (i <= mid) {
            result[k++] = nums[i++];
        }

        while (j <= end) {
            result[k++] = nums[j++];
        }

        //合并空间元素替换到原始数组中
        while (start <= end) {
            nums[start] = result[start++];
        }
    }

    private static void looger(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n-----------------------");
    }
}
