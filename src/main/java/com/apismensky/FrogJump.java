package com.apismensky;

import static java.util.Arrays.binarySearch;
import static java.util.Arrays.fill;

import java.util.Arrays;

/**
 * A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone.
 * The frog can jump on a stone, but it must not jump into the water.
 *
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.
 *
 * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.
 *
 * Note:
 *
 * The number of stones is ≥ 2 and is < 1,100.
 * Each stone's position will be a non-negative integer < 231.
 * The first stone's position is always 0.
 * Example 1:
 *
 * [0,1,3,5,6,8,12,17]
 *
 * There are a total of 8 stones.
 * The first stone at the 0th unit, second stone at the 1st unit,
 * third stone at the 3rd unit, and so on...
 * The last stone at the 17th unit.
 *
 * Return true. The frog can jump to the last stone by jumping
 * 1 unit to the 2nd stone, then 2 units to the 3rd stone, then
 * 2 units to the 4th stone, then 3 units to the 6th stone,
 * 4 units to the 7th stone, and 5 units to the 8th stone.
 * Example 2:
 *
 * [0,1,2,3,4,8,9,11]
 *
 * Return false. There is no way to jump to the last stone as
 * the gap between the 5th and 6th stone is too large.
 *
 *
 Approach #4 Using Memorization with Binary Search [Accepted]
 Algorithm

 In the brute force approach, we make use of a recursive function canCrosscanCross which takes the given stone array,
 the current position and the current jumpsizejumpsize as input arguments.
 We start with currentPosition=0currentPosition=0 and jumpsize=0jumpsize=0.
 Then for every function call, we start from the currentPositioncurrentPosition and check
 if there lies a stone at (currentPostion + newjumpsize)(currentPostion+newjumpsize),
 where, the newjumpsizenewjumpsize could be jumpsizejumpsize, jumpsize+1jumpsize+1 or jumpsize-1jumpsize−1.
 In order to check whether a stone exists at the specified positions, we check the elements of the array in a linear manner.
 If a stone exists at any of these positions, we call the recursive function again
 with the same stone array, the currentPositioncurrentPosition and the newjumpsizenewjumpsize as the parameters.
 If we are able to reach the end of the stone array through any of these calls, we
 return truetrue to indicate the possibility of reaching the end.

 Another problem with above approaches is that we can make the same function calls coming through different paths e.g.
 For a given currentIndexcurrentIndex, we can call the recursive function canCrosscanCross with the jumpsizejumpsize, say nn.
 This nn could be resulting from previous jumpsizejumpsize being n-1n−1,nn or n+1n+1.
 Thus, many redundant function calls could be made prolonging the running time.
 This redundancy can be removed by making use of memorization.
 We make use of a 2-d memomemo array, initialized by -1−1s, to store the result returned from a function
 call for a particular currentIndexcurrentIndex and jumpsizejumpsize.
 If the same currentIndexcurrentIndex and jumpsizejumpsize happens is encountered again,
 we can return the result directly using the memomemo array. This helps to prune the search tree to a great extent.

 We can optimize the above memorization approach, if we make use of Binary Search to find if
 a stone exists at currentPostion + newjumpsizecurrentPostion+newjumpsize instead of searching linearly.
 */
public class FrogJump {
    public boolean canCross(int[] stones) {
        int[][] memo = new int[stones.length][stones.length];
        for (int[] row : memo) {
            fill(row, -1);
        }
        return canCross(stones, 0, 0, memo) == 1;
    }
    public int canCross(int[] stones, int ind, int jumpsize, int[][] memo) {
        if (memo[ind][jumpsize] >= 0) {
            return memo[ind][jumpsize];
        }
        int ind1 = binarySearch(stones, ind + 1, stones.length, stones[ind] + jumpsize);
        if (ind1 >= 0 && canCross(stones, ind1, jumpsize, memo) == 1) {
            memo[ind][jumpsize] = 1;
            return 1;
        }
        int ind2 = binarySearch(stones, ind + 1, stones.length, stones[ind] + jumpsize - 1);
        if (ind2 >= 0 && canCross(stones, ind2, jumpsize - 1, memo) == 1) {
            memo[ind][jumpsize - 1] = 1;
            return 1;
        }
        int ind3 = binarySearch(stones, ind + 1, stones.length, stones[ind] + jumpsize + 1);
        if (ind3 >= 0 && canCross(stones, ind3, jumpsize + 1, memo) == 1) {
            memo[ind][jumpsize + 1] = 1;
            return 1;
        }
        memo[ind][jumpsize] = ((ind == stones.length - 1) ? 1 : 0);
        return memo[ind][jumpsize];
    }
}
