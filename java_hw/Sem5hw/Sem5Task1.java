/* 	2085. Подсчитайте общеупотребительные слова с одним вхождением.
	Имея два массива строк words1 и words2, вернуть количество строк, 
	встречающихся ровно один раз в каждом из двух массивов.
*/

class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> count = new HashMap<>();

        for (final String word : words1) {
            count.merge(word, 1, Integer::sum);
        }

        for (final String word : words2) {
            if (count.containsKey(word) && count.get(word) < 2) {
                    count.merge(word, -1, Integer::sum);
            }
        }

        return (int) count.values().stream().filter(v -> v == 0).count();
    }
}