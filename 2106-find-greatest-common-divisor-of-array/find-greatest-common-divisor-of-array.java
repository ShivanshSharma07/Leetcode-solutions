class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
      
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        
    
        while (min != 0) {
            int temp = min;
            min = max % min;
            max = temp;
        }
        
        return max;
    }
}