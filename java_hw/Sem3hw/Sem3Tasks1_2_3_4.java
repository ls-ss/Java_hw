/*  Task1. На вход приходят два ArrayList<Integer> напишите метод, который проверяет два массива на равенство.
        Нужно реализовать алгоритм, не использовать метод equals.
    Task2. На вход методу приходят два ArrayList<Integer> и целое число num. 
        Проверьте, что число num встречается в обоих массивах одинаковое кол-во раз.
    Task3. На вход приходит ArrayList<Integer>. Отсортируйте в нем только четные числа. 
        Пример: [10, 4, 5, 6, 7, 2, 2, 9] -> [2, 2, 5, 4, 7, 6, 10, 9]
    Task4. На вход приходт ArrayList<Integer> удалите из него четные числа (на итератор).
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Task1.
        ArrayList<Integer> list1a = new ArrayList<>(Arrays.asList(1, 2, -3));                
        ArrayList<Integer> list1b = new ArrayList<>(Arrays.asList(1, 2, -3));
        System.out.println(equalList(list1a, list1b));

        //Task2.
        ArrayList<Integer> list2a = new ArrayList<>(Arrays.asList(0, -1, -2, -1, -1, -2, 0));
        ArrayList<Integer> list2b = new ArrayList<>(Arrays.asList(-1, 2, 0, -1, -1));
        System.out.println(countNum(list2a, list2b, -1));

        //Task3.
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(10, 4, 5, 6, 7, 2, 2, 9));
        System.out.println(sortEvenNum(list3));

        //Task4.
        ArrayList<Integer> list4 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(removeEvenNum(list4));
    }

    //Ф-ция для Task1
    public static boolean equalList(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        
        return true;
    }

    //Ф-ция для Task2
    public static boolean countNum(ArrayList<Integer> list1, ArrayList<Integer> list2, int num) {
        int cnt1 = 0;
        int cnt2 = 0;
        
        for (int n : list1) {
            if (n == num) {
                cnt1++;
            }
        }
        
        for (int n : list2) {
            if (n == num) {
                cnt2++;
            }
        }
        
        return cnt1 == cnt2;
    }

    //Ф-ция для Task3
    public static ArrayList<Integer> sortEvenNum(ArrayList<Integer> list) {
        ArrayList<Integer> newlist = new ArrayList<>();
        for (int n : list) {
            if (n % 2 == 0) {
                newlist.add(n);
            }
        }
        
        java.util.Collections.sort(newlist);
        int j = 0;
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.set(i, newlist.get(j));
                j++;
            }
        }
        
        return list;
    }

    //Ф-ция для Task4
    public static ArrayList<Integer> removeEvenNum(ArrayList<Integer> list) {
        list.removeIf(integer -> integer % 2 == 0);
        return list;
    }
}

/* Результаты исполнения кода:
true
true
[2, 2, 5, 4, 7, 6, 10, 9]
[1, 3, 5]
*/