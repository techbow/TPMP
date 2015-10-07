public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if(m <= 0 && n <= 0){
            return 0;
        }
        int[] result = new int[n];
        result[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for(int i = 1; i < n; i++){
            result[i] = obstacleGrid[0][i] == 1 ? 0 : result[i-1];
        }
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                if(j == 0){
                    result[j] = obstacleGrid[i][0] == 1 ? 0 : result[j];
                }
                else{
                    result[j] = obstacleGrid[i][j] == 1 ? 0 : result[j] + result[j - 1];
                }
                
            }
        }
        return result[n-1];
    }
}