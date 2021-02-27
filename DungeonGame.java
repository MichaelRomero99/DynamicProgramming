import java.util.*;
public class DungeonGame {
	//Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
	//knight is located in (0,0) on dungeon
	//princess is located in (n,m)
	//you can only go down or right
	public static int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row][col];
        //At every position, we want to determine what is the cost we need to visit the cells.
        //if the cost(dungeon cell + the next cell) is > 0, then we dont need health to visit that cell
        //so place 0, else place the cost we need to visit the cells.
        //
        for(int i = row-1; i >= 0; i --){
            for(int j = col-1; j >= 0;j--){
                //base case
                if(i == row-1 && j == col-1){
                    dp[i][j] = Math.min(0,dungeon[i][j]);
                }else if(i == row-1){
                    //ony go right
                    dp[i][j] = Math.min(0,dungeon[i][j] + dp[i][j+1]);
                }else if(j == col-1){
                    //only go  down
                    dp[i][j] = Math.min(0,dungeon[i][j] + dp[i+1][j]);
                }else{
                    //we want to chose the path(down,right) which requires the least amount of health we need to
                    int min = Math.max(dp[i][j+1],dp[i+1][j]);
                    int cost = dungeon[i][j] + min;
                    if(cost >= 0){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = cost;
                    }
                    
                }
            }
        }
        
        return Math.abs(dp[0][0])+1;//+1 because we can't be in a cell with 0 health
    }
	public static void main(String[] args) {
		int[][] dungeon = new int[3][3];
		dungeon[0] = new int[] {-2,-3,3};
		dungeon[1] = new int[] {-5,-10,1};
		dungeon[2] = new int[] {10,30,-5};
		System.out.println(calculateMinimumHP(dungeon));//ans = 7
		System.out.println(calculateMinimumHP(dungeon));//ans = 7
	}

}
