package g0401_0500.s0498_diagonal_traverse;

// #Medium #Array #Matrix #Simulation #2022_03_19_Time_2_ms_(96.07%)_Space_44.2_MB_(87.02%)

public class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] output = new int[m * n];
        int idx = 0;
        for (int diag = 0; diag <= m + n - 2; ++diag) {
            if (diag % 2 == 0) {
                for (int k = Math.max(0, diag - m + 1); k <= Math.min(diag, n - 1); ++k) {
                    output[idx++] = mat[diag - k][k];
                }
            } else {
                for (int k = Math.max(0, diag - n + 1); k <= Math.min(diag, m - 1); ++k) {
                    output[idx++] = mat[k][diag - k];
                }
            }
        }
        return output;
    }
}
