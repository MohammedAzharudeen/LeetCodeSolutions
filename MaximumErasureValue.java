/*
You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
*/


class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        int start = 0;
        int i = 0;
        int runningSum = 0;
        int maxSum = 0;
        int deleteEl = 0;
        
        while(i < nums.length) {
            int currEl = nums[i];
            if(!set.contains(currEl)){
                set.add(currEl);
                runningSum += currEl;
                maxSum = Math.max(runningSum,maxSum);
                i++;
            }
            else {
                deleteEl = nums[start];
                set.remove(deleteEl);
                runningSum -= deleteEl;
                start++;
            }
        }
        return maxSum;
    }
}
