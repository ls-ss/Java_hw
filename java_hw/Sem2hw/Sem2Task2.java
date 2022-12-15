/* 	Изображение представлено изображением целочисленной сетки m x n, где image[i][j] 
	представляет значение пикселя изображения.

	Вам даны три целых числа sr, sc и цвет. Вы должны выполнить заливку изображения, 
	начиная с пиксельного изображения[sr][sc].

	Чтобы выполнить заливку, рассмотрите начальный пиксель плюс любые пиксели, соединенные 
	в 4 направлениях с начальным пикселем того же цвета, что и начальный пиксель, плюс любые
	пиксели, соединенные в 4 направлениях с этими пикселями (также с тем же цветом), 
	и скоро. Замените цвет всех вышеупомянутых пикселей цветом.

	Верните измененное изображение после выполнения заливки.
*/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor != color) {
            floodFillAroundCell(image, sr, sc, oldColor, color);
        }
        return image;
    }

    public void floodFillAroundCell(int[][] image, int row, int col, int oldColor, int newColor) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] == newColor) {
            return;
        }

        if (image[row][col] == oldColor) {
            image[row][col] = newColor;
            floodFillAroundCell(image, row - 1, col, oldColor, newColor);
            floodFillAroundCell(image, row + 1, col, oldColor, newColor);
            floodFillAroundCell(image, row, col - 1, oldColor, newColor);
            floodFillAroundCell(image, row, col + 1, oldColor, newColor);
        }
    }
}
