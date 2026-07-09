// Last updated: 09/07/2026, 15:12:06
class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for(int i = 0;i<n;i++){
            sum+=mat[i][i];
            if(i!=n-1-i){
                sum+=mat[i][n-1-i];
            }
        }
        return sum;
    }
}