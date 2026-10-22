class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean isSorted = true;
        char minChar = 'z';
        char maxChar = 'a';
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (i > 0 && c < s.charAt(i - 1)) {
                isSorted = false;
            }
            if (c < minChar) minChar = c;
            if (c > maxChar) maxChar = c;
        }
        
        if (isSorted) return 0;
        
        if (n == 2) return -1;
        
        if (s.charAt(0) == minChar || s.charAt(n - 1) == maxChar) {
            return 1;
        }
        
        int minCount = 0;
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == minChar) minCount++;
            if (s.charAt(i) == maxChar) maxCount++;
        }
        
        if (s.charAt(0) == maxChar && maxCount == 1 && 
            s.charAt(n - 1) == minChar && minCount == 1) {
            return 3;
        }
        
        return 2;
    }
}