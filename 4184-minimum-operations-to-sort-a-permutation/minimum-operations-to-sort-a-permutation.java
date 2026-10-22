class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }

        boolean isInc = true;
        boolean isDec = true;
        int idx0 = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                idx0 = i;
            }
            int next = nums[(i + 1) % n];
            if (next != (nums[i] + 1) % n) {
                isInc = false;
            }
            if (next != (nums[i] - 1 + n) % n) {
                isDec = false;
            }
        }

        if (!isInc && !isDec) {
            return -1;
        }

        int ans = Integer.MAX_VALUE;

        if (isInc) {
            int op1 = idx0;
            int op2 = 2 + (n - idx0) % n;
            ans = Math.min(ans, Math.min(op1, op2));
        }

        if (isDec) {
            int op1 = 1 + (idx0 + 1) % n;
            int op2 = 1 + (n - 1 - idx0);
            ans = Math.min(ans, Math.min(op1, op2));
        }

        return ans;
    }
}