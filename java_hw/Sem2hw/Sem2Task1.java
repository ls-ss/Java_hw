/* Вам дана бинарная матричная сетка размера m x n. Остров представляет собой группу единиц
(представляющих землю), соединенных в четырех направлениях (по горизонтали или по вертикали).
Можно предположить, что все четыре края сетки окружены водой.

Площадь острова — это количество ячеек со значением 1 на острове.

Возвращает максимальную площадь острова в сетке. Если острова нет, вернуть 0.
*/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxIsl = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxIsl = Math.max(maxIsl, getCountAreaOfIsland(i, j, grid));
                }
            }
        }
        return maxIsl;
    }

    public int getCountAreaOfIsland(int row, int col, int[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return 0;
        }
        if (grid[row][col] == 1) {
            grid[row][col] = 0;
            int getSum = getCountAreaOfIsland(row + 1, col, grid) + getCountAreaOfIsland(row - 1, col, grid)
                       + getCountAreaOfIsland(row, col - 1, grid) + getCountAreaOfIsland(row, col + 1, grid);
            return 1 + getSum;
        }
        return 0;
    }
}