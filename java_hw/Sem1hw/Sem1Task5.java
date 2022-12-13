/* 5. Фраза является палиндромом, если после преобразования всех прописных букв в строчные и 
   удаления всех не буквенно-цифровых символов она читается одинаково вперед и назад. 
   Буквенно-цифровые символы включают буквы и цифры.
   Учитывая строку s, вернуть true, если это палиндром, или false в противном случае.
   PS: (новые строки создавать нельзя, метод replace/replaceAll под запретом)нужно пропустить 
   все не буквы или цифры. Есть метод Character.isLetterOrDigit(char ch). Принимает символ и 
   говорит это буква или цифра. Заводим указатель left = 0; right = string.length() - 1. Перед 
   тем как проверить двигаем их пока не встанем в символ. Метод replace под запретом, строку 
   создавать новую или менять исходную нельзя
*/

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left += 1;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right -= 1;
            }
            
            char leftChar = Character.toLowerCase(s.charAt(left++));
            char rightChar = Character.toLowerCase(s.charAt(right--));
            if (leftChar != rightChar) {
                return false;
            }
        }        
        return true;
    }
}
