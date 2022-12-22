/* 542. 01 Матрица.
	Учитывая бинарную матрицу m x n, верните расстояние до ближайшего 0 для каждой ячейки.

	Расстояние между двумя соседними ячейками равно 1.
*/

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int colLen = mat.length;
        int rowLen = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < colLen; i++) {
            for (int j = 0; j < rowLen; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] steps = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] step : steps) {
                int r = cell[0] + step[0];
                int c = cell[1] + step[1];
                if (r < 0 || r >= colLen || c < 0 || c >= rowLen ||
                        mat[r][c] <= mat[cell[0]][cell[1]] + 1) continue;
                queue.add(new int[]{r, c});
                mat[r][c] = mat[cell[0]][cell[1]] + 1;
            }
        }
		
        return mat;
    }
}