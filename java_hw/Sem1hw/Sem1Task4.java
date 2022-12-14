/* Учитывая входную строку s, измените порядок слов на противоположный.
Слово определяется как последовательность не пробельных символов. 
Слова в s будут разделены хотя бы одним пробелом.
Возвращает строку слов в обратном порядке, объединенных одним пробелом.
Обратите внимание, что s может содержать начальные или конечные пробелы или 
несколько пробелов между двумя словами. Возвращаемая строка должна содержать 
только один пробел, разделяющий слова. Не включайте никаких дополнительных пробелов.
PS: (в записи есть решение, новые строки создавать нельзя, методы replaceAll, 
split запрещены) заводим переменные end (указатель на конец слова, двигаем пока 
не достигли символа) заводим start = end - 1 и двигаем пока не дойдем до пробела.
*/

class Solution {
    public String reverseWords(String s) {
        StringBuilder txt = new StringBuilder();
        int end = s.length() - 1;
        while (end >= 0) {
            if (s.charAt(end) == ' ') {
                end -= 1;
                continue;
            }
            int start = end - 1;
            while (start >= 0 && s.charAt(start) != ' ') {
                start -= 1;
            }
            txt.append(" ");
            txt.append(s.substring(++start,++end));
            end = start - 1;
        }
        if (txt.length() > 0) {
            txt.deleteCharAt(0);
        }
        return txt.toString();
    }
}
