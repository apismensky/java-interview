package com.apismensky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
 *
 * Example:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * Note that different sequences are counted as different combinations.
 *
 * Therefore the output is 7.
 *
 * So we know that target is the sum of numbers in the array. Imagine we only need one more number to reach target,
 * this number can be any one in the array, right?
 * So the # of combinations of target, comb[target] = sum(comb[target - nums[i]]), where 0 <= i < nums.length, and target >= nums[i].
 *
 * In the example given, we can actually find the # of combinations of 4 with the # of combinations
 * of 3(4 - 1), 2(4- 2) and 1(4 - 3). As a result, comb[4] = comb[4-1] + comb[4-2] + comb[4-3] = comb[3] + comb[2] + comb[1].
 *
 * Then think about the base case. Since if the target is 0,
 * there is only one way to get zero, which is using 0, we can set comb[0] = 1.
 *
 * EDIT: The problem says that target is a positive integer that makes me feel it's unclear to put it in the above way.
 * Since target == 0 only happens when in the previous call,
 * target = nums[i], we know that this is the only combination in this case, so we return 1.
 *
 * Now we can come up with at least a recursive solution.
 */
public class CombinationSum {
    public static int combinationSum(int[] nums, int target) {
        //System.out.println("target = " +  target);
        if (target == 0) {
            //System.out.println("returning te base case");
            return 1;
        }
        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                //System.out.println("In loop, target >= num, " + target + ">=" + num);
                res += combinationSum(nums, target - num);
            }
        }
        //System.out.println("returning res: " + res);
        return res;
    }

    /**
     * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
     *
     * The same repeated number may be chosen from candidates unlimited number of times.
     *
     * Note:
     *
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combine(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    private static void combine(List<List<Integer>> result,
                         List<Integer> cur,
                         int[] nums,
                         int target,
                         int start) {
        if (target > 0) {
            for (int i = start; i < nums.length; i++) {
                cur.add(nums[i]);
                combine(result, cur, nums, target - nums[i], i);
                cur.remove(cur.size() - 1);
            }
        }
        if (target == 0) {
            result.add(new ArrayList<>(cur));
        }
    }

    /**
     * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
     *
     * Each number in candidates may only be used once in the combination.
     *
     * Note:
     *
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * Example 1:
     *
     * Input: candidates = [10,1,2,7,6,1,5], target = 8,
     * A solution set is:
     * [
     *   [1, 7],
     *   [1, 2, 5],
     *   [2, 6],
     *   [1, 1, 6]
     * ]
     * Example 2:
     *
     * Input: candidates = [2,5,2,1,2], target = 5,
     * A solution set is:
     * [
     *   [1,2,2],
     *   [5]
     * ]
     */
    public static List<List<Integer>> combinationSum3(int[] cand, int target) {
        Arrays.sort(cand);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs_com(cand, 0, target, path, res);
        return res;
    }

    private static void dfs_com(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(path));
            return ;
        }
        if (target < 0) return;
        for (int i = cur; i < cand.length; i++){
            if (i > cur && cand[i] == cand[i-1]) continue;
            path.add(path.size(), cand[i]);
            dfs_com(cand, i+1, target - cand[i], path, res);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        System.out.println(combinationSum(input, 4));
        System.out.println(combinationSum2(input, 4));


        input = new int[] {2,7,6,3};
        System.out.println(combinationSum(input, 7));
        System.out.println(combinationSum2(input, 7));

        input = new int[] {2,3,5};

        System.out.println(combinationSum(input, 8));
        System.out.println(combinationSum2(input, 8));

        input = new int[] {10,1,2,7,6,1,5};
        System.out.println(combinationSum3(input, 8));
    }
}
