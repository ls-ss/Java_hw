/* 695. Максимальная площадь острова.
	Вам дана бинарная матричная сетка размера m x n. Остров представляет собой группу единиц 
	(представляющих землю), соединенных в четырех направлениях (по горизонтали или по вертикали). 
	Можно предположить, что все четыре края сетки окружены водой.

	Площадь острова — это количество ячеек со значением 1 на острове.

	Возвращает максимальную площадь острова в сетке. Если острова нет, вернуть 0.
*/

class Solution {
    public static int maxAreaOfIsland(int[][] grid) {
        int[][] steps = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int maxSize = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x] == 1) {
                    LinkedList<int[]> islands = new LinkedList<>();
                    int curArea = 0;
                    islands.add(new int[]{y, x});
                    while (!islands.isEmpty()) {
                        int[] curIsland = islands.pop();
                        if (grid[curIsland[0]][curIsland[1]] == 1) {
                            curArea++;
                            grid[curIsland[0]][curIsland[1]] = 0;
                            for (int[] step : steps) {
                                int curX = curIsland[1] + step[1];
                                int curY = curIsland[0] + step[0];
                                if (curX >= 0 && curX < grid[0].length && curY >= 0
                                        && curY < grid.length && grid[curY][curX] == 1) {
                                    islands.add(new int[]{curY, curX});
                                }
                            }
                        }
                    }
                    maxSize = Math.max(curArea, maxSize);
                }
            }
        }
        return maxSize;
    }
}