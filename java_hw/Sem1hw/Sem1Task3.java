/* Вам даны два массива целых чисел nums1 и nums2, отсортированные в неубывающем порядке, и два целых числа m и n, 
представляющие количество элементов в nums1 и nums2 соответственно.
Объедините nums1 и nums2 в один массив, отсортированный в неубывающем порядке.
Окончательный отсортированный массив не должен возвращаться функцией, а должен храниться внутри массива nums1. 
Чтобы приспособиться к этому, nums1 имеет длину m + n, где первые m элементов обозначают элементы, которые должны 
быть объединены, а последние n элементов устанавливаются равными 0 и должны игнорироваться. nums2 имеет длину n. */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int pos = m + n - 1;
        m = m - 1;
        n = n - 1;
        while (n >= 0) {
            if (m >= 0 && nums1[m] > nums2[n]) {
                nums1[pos] = nums1[m];
                pos--;
                m--;
            } else {
                nums1[pos] = nums2[n];
                pos--;
                n--;
            }
        }
    }
}