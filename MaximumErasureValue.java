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
