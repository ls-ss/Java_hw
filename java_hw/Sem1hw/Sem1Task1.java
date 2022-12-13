/* Вам даны две строки word1 и word2. Объедините строки, добавляя буквы в чередующемся порядке, начиная с word1 . 
Если строка длиннее другой, добавьте дополнительные буквы в конец объединенной строки.
Вернуть объединенную строку.
*/

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int max = Math.max(word1.length(), word2.length());
        for (int i = 0; i < max; i++) {
            if (i < word1.length()) res.append(word1.charAt(i));
            if (i < word2.length()) res.append(word2.charAt(i));
        }
        return res.toString();
    }
}
  