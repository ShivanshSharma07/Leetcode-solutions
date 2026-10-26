class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    long islandSum = bfs(grid, visited, i, j, m, n);
                    if (islandSum % k == 0) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
    
    private long bfs(int[][] grid, boolean[][] visited, int startRow, int startCol, int m, int n) {
        long sum = 0;
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        queue.offer(new int[] {startRow, startCol});
        visited[startRow][startCol] = true;
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            sum += grid[r][c];
            
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] > 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[] {nr, nc});
                }
            }
        }
        
        return sum;
    }
}