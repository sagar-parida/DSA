// 238. Product of Array Except Self
// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// You must write an algorithm that runs in O(n) time and without using the division operation.

// Example 1:

// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]
// Example 2:

// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]

// Constraints:

// 2 <= nums.length <= 105
// -30 <= nums[i] <= 30
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

package DSA.ArrayString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductArrayExceptSelf {

    public static void main(String[] args) {
        printArray(productExceptSelf(new int[] { 1, 2, 3, 4 }));
        printArray(productExceptSelf(new int[] { -1, 1, 0, -3, 3 }));
    }

    public static void printArray(int[] nums) {
        List<Integer> tums = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(tums);
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        int[] postFixProduct = new int[nums.length];

        int product1 = 1;
        int product2 = 1;

        for (int i = 0; i < nums.length; i++) {
            product1 = product1 * (i == 0 ? 1 : nums[i - 1]);
            prefixProduct[i] = product1;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            product2 = product2 * (i == nums.length - 1 ? 1 : nums[i + 1]);
            postFixProduct[i] = product2;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = prefixProduct[i] * postFixProduct[i];
        }

        return nums;
    }
}
